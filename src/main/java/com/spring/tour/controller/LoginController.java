package com.spring.tour.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.spring.tour.login.Kakao_restAPI;
import com.spring.tour.login.Login_Interface;
import com.spring.tour.login.PasswordEncoding;
import com.spring.tour.vo.User_InfoVo;

@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
	private Login_Interface login_Interface;
	
	private Kakao_restAPI kakao_restAPI = new Kakao_restAPI();

	
	@RequestMapping("/userlogin")
	public String login() {
		return ".userjoin.userlogin";
	}
	
	//로그인 처리
		@RequestMapping(value="/loginCheck")
		public ModelAndView loginCheck(@ModelAttribute User_InfoVo vo,HttpSession session) {
			ModelAndView mav = new ModelAndView();
			PasswordEncoding pe = new PasswordEncoding();
			
			User_InfoVo result = login_Interface.loginCheck(vo, session);
			boolean mat = pe.matches(vo.getUser_pass(), result.getUser_pass());
			mav.setViewName(".userjoin.successTest");
			
			String con = result.getUser_condition();
			
			if(mat) {
				if(con.equals("1")) {
					mav.addObject("msg","메일 인증 됌");
					session.setAttribute("user_id", vo.getUser_id());
				}else if(con.equals("0")){
					mav.addObject("msg","메일 인증 안됌");
				}else {
					mav.addObject("msg","탈퇴한 회원");
				}
			}else {
				mav.addObject("msg","가입 안됬음");
			}
				return mav;
			
		}
		
		//로그아웃 처리
		@RequestMapping("/logout")
		public ModelAndView logout(HttpSession session) {
			
			login_Interface.logout(session);
			ModelAndView mav = new ModelAndView();
			mav.setViewName(".userjoin.successTest");
			mav.addObject("msg", "logout");
			
			return mav;
		}
		
		//카카오 컨트롤러
		@RequestMapping(value="/kakaologin",produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST})
		public String kakaoLogin(@RequestParam("code") String code, Model model, HttpSession session) {
			System.out.println("로그인 할때 임시 코드값");
	        //카카오 홈페이지에서 받은 결과 코드
	        System.out.println(code);
	        System.out.println("로그인 후 결과값");
	        
	        //카카오 rest api 객체 선언
	        Kakao_restAPI kr = new Kakao_restAPI();
	        //결과값을 node에 담아줌
	        JsonNode node = kr.getAccessToken(code);
	        //결과값 출력
	        System.out.println(node);
	        //노드 안에 있는 access_token값을 꺼내 문자열로 변환
	        String token = node.get("access_token").toString();
	        //세션에 담아준다.
	        session.setAttribute("token", token);
	        
	        return ".userjoin.kakaoTest";

		}
		
		@RequestMapping(value = "/kakaologout", produces = "application/json")
	    public String Logout(HttpSession session) {
	        //kakao restapi 객체 선언
	        Kakao_restAPI kr = new Kakao_restAPI();
	        //노드에 로그아웃한 결과값음 담아줌 매개변수는 세션에 잇는 token을 가져와 문자열로 변환
	        JsonNode node = kr.Logout(session.getAttribute("token").toString());
	        //결과 값 출력
	        System.out.println("로그인 후 반환되는 아이디 : " + node.get("id"));
	        return "redirect:/";
	    } 
}
