<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
/* 밑으로 채팅!! */

#chat_icon{
	right:20px;
	bottom:30px;
	position:fixed;
}

#chat_window{
	width:300px;
	height:600px;
	position :fixed;
	right: 10px;
	bottom: 100px;
	background-color: #F1ECDA;
	border-radius:5%;
	display:none;
}

#callwrap{
	position:absolute;
	width:300px;
	height:600px;
	background-color: #4E61FF;
	color:white;
	opacity:100%;
	z-index: 99;
	border-radius:5%;
	display: block;
}

#callwrap p{
	font-size:25px;
}

#call{
	position: relative;
	width:250px;
	height: 50px;
	top: 350px;
	left: 30px;
	text-align: center;
	align-items: center;
}	

 
#messages{
	position:relative;
	width:100%;
	height: 400px;
	background-color:#F5F3EB;
	
	display:flex;  /*flex direction 사용하기 위함 */
	flex-direction: column-reverse; /*스크롤 하단 고정 */
    overflow-y:auto;  /* 내용이 설정된 height을 넘기면 자동으로 스크롤 생성 */

	border-radius: 5% 5% 0% 0%;
	word-break:break-all; /* 글자가 div를 넘어가지 않도록*/
}


#messages::-webkit-scrollbar {
   	width: 8px;
}
	 
#messages::-webkit-scrollbar-thumb {
    background-color: #2f3542;
    border-radius: 10px;
    background-clip: padding-box;
    border: 2px solid transparent;
}
#messages::-webkit-scrollbar-track {
    background-color: grey;
    border-radius: 10px;
    box-shadow: inset 0px 0px 5px white;
}

#btnbox{
	height:150px;
	background-color: white;
	border-radius:0% 0% 5% 5%;
}

#closebtn{
	float:right;
}
#inputtext{
	border:1px solid white;
	style="margin:5px;"
}
 
.fromM{/* 내 메세지 div */
	text-align:right;
	margin :8px;
	margin-left:60px;
	word-break:break-all;
}

.fromC{ /* 내가 아닌 메세지 div  */ 
	margin :8px;
	margin-right:60px;
	font-weight: 500;
	word-break:break-all;
}
.mTag{/* 내용에 입힐 CSS */
	margin:3px;
}
.cTag{/* */
	margin:0;
	font-weight: 700;
}

input:focus, textarea:focus, select:focus, button:focus{
    outline: none;
}

#messageSend{
	background-color:transparent;
	border-radius: 15px 15px 15px 15px;
	padding:5px;
}
#messageSend:hover{
	box-shadow: 1px 1px 2px 1px gray;
}

</style>    
	<footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; ConnecTrip 2021</p>
      <input type="hidden" id="sender" value="none"><br>
	<div id="chat_icon"><i class="far fa-comment-dots fa-2x"></i></div>
	<div id="chat_window">
		<div id="callwrap">
			<div id="call"><i class="fas fa-concierge-bell fa-3x"></i><br>
			<p style="font-weight:700" id="serverMsg">Call Manager!</p>
			</div>
		</div>
		<div style="float:right; margin-right:10px;" id="closebtn"><i class="fas fa-times fa-lg"></i></div>
		<div id="messages">
		</div>
		<div id="btnbox">
			<textarea id="inputtext" style="width:230px; height:150px; resize:none;" ></textarea>
			<input type="button" value="SEND" id="messageSend" onclick="send()" style="float:right; margin:5px;"><br>
		</div>
	</div>
    </div>
  </footer>

<script type="text/javascript">
	
	var ws;
	
	var messages = document.getElementById("messages"); 
	
	
    var doubleSubmitFlag = false;
    function doubleSubmitCheck(){
        if(doubleSubmitFlag){
            return doubleSubmitFlag;
        }else{
            doubleSubmitFlag = true;
            return false;
        }
    }

	$("#chat_icon").on("click",function(){ 
		$("#chat_window").toggle(500);
	});
	
	
	$("#closebtn").on("click",function(){ // 닫으면 종료
		
		closeSocket();
		$("#chat_window").toggle(500);
		$("#messages").empty();
		$.getJSON("${cp}/logout.do", {"username":$("#sender").val()}, // 디비에서 로그아웃 로그해주기
				function(data) {
			console.log("DB데이터처리는 ! : "+data.code);
		});
		$("#callwrap").fadeIn(700);
	});
	 
	$("#call").on('click',function(){
		if(doubleSubmitCheck()) return;
		$.getJSON("${cp}/login.do", function(data) {
			if(data.code=='success'){
				var username = data.username;
				$("#sender").val(username);
				openSocket();
				$("#callwrap").fadeOut(300); // 소켓 남은게 있으면 다음단계로 넘어가기
				$("#inputtext").focus();
			}else{
				$("#serverMsg").text(data.errorMsg);
				return;
			}
		});
	});
	
	function openSocket(){
		writeResponse("SYSTEM잠시만 기다려주세요.");
		if(ws!= undefined && ws.readyState != WebSocket.CLOSED){
			writeResponse("SYSTEMws WebSocket is already opended");
			return;
		}
		//웹 소켓 만드는 코드
		var username = document.getElementById("sender").value;
		
		var whichSC = "";
		if(username=='customer1'){
			whichSC = "echo1.do";
		}else if(username=='customer2'){
			whichSC = "echo2.do";
		}else if(username=='customer3'){
			whichSC = "echo3.do";
		}else if(username=='customer4'){
			whichSC = "echo4.do";
		}
		
		ws = new WebSocket("ws://localhost:9090/tour/"+whichSC);
		
		ws.onopen = function(event){
			if(event.data== undefined){
				ws.send(username+"님이 접속하셨습니다.,"+username);
				return;
			}
			writerResponse(event.data);
			ws.send(username+",님이 접속하셨습니다.");
		}
		ws.onmessage = function(event){
			console.log('writeResponse');
			console.log('ws에서 받아온 메세지 :' + event.data);
			writeResponse(event.data);
		}
		ws.onclose=function(event){
			writeResponse("SYSTEM대화를 종료합니다.");
			$("#messages").empty();
			doubleSubmitFlag=false;
		}
	}
	
	//////////////////////
	
	function send(){
		var text = document.getElementById("inputtext").value+
			","+document.getElementById("sender").value;
		ws.send(text);
		text="";
		document.getElementById("inputtext").value="";
	}
	
	document.getElementById("inputtext").addEventListener("keydown", function(e) {
		if(e.keyCode==13){
		    if (!event.shiftKey){
				e.preventDefault();//엔터는 원래는 줄바꿈인데 막고 전송으로!(필요시)
				send();
            }
		}
	}, false);
	///////////////////////
	
	
	function closeSocket(){ // JSON으로 디비 정보 수정해주기 
		ws.close();
		$.getJSON("${cp}/logout.do", {"username":$("#sender").val()}, // 디비에서 로그아웃 로그해주기
				function(data) {
			console.log("DB데이터처리는 ! : "+data.code);
		});
	}
	
	function writeResponse(text){
		if(text.includes("#$#")){ //내가 보낸 메세지라는 표시
			var ntext = text.replace("#$#", "");
			messages.innerHTML = "<div class='fromM'><span class='mTag'>"+ntext+"</span></div>"+messages.innerHTML;
		}else if(text.includes("SYSTEM")){ //시스템이 보내는 메세지
			var ntext= text.replace("SYSTEM","");
			messages.innerHTML = "<div class='fromC'><p class='cTag'>SYSTEM</p><span>"+ntext+"</span></div>"+messages.innerHTML;
		}else{
			messages.innerHTML = "<div class='fromC'><p class='cTag'>MANAGER</p><span>"+text+"</span></div>"+messages.innerHTML;
		}
	}
	
	function clearText(){
		document.getElementById("messages").innerHTML="";
	}
</script>