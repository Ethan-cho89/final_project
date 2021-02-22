package com.spring.tour.security;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.tour.dao.MemberDao;
import com.spring.tour.vo.IdTokenVo;
import com.spring.tour.vo.User_InfoVo;

@Service
public class MemberService {
	@Autowired private PasswordEncoder encoder;
	
	@Autowired MemberDao dao;
	@Autowired private JavaMailSender mailSender;
	
	public int insert(User_InfoVo vo,HttpServletRequest req) throws Exception{
		String password=vo.getUser_pass();
		vo.setUser_pass(encoder.encode(password));
		dao.insert(vo);
		IdTokenVo avo=new IdTokenVo();
		avo.setUser_id(vo.getUser_id());
		String type = req.getParameter("usertype");
		if(type.equals("ADMIN")) {//������ ��������
			avo.setToken_authority("ROLE_ADMIN");
		}else if(type.equals("partner")) {//���� ������ ��������
			avo.setToken_authority("ROLE_PARTNER");
		}else {//�Ϲ�ȸ�� ��������
			avo.setToken_authority("ROLE_MEMBER");
		}
		
		String key = new TempKey().getKey(50, false); // ����Ű ����
		avo.setToken_data(key);
		//dao.createAuthKey(vo.getUser_email(), key);
		
		dao.insert(avo);
		if(type.equals("member")) {
			MailHandler sendMail = new MailHandler(mailSender);
			sendMail.setSubject("[ConnecTrip �Ϲ� ȸ�� ���� �̸���]");
			sendMail.setText(
					new StringBuffer().append("<h1>��������</h1>").append("<a href='http://localhost:8081/tour/emailConfirm?user_email=").append(vo.getUser_email()).append("&key=").append(key).append("' target='_blenk'>�̸��� ���� Ȯ��</a>").toString());
			sendMail.setFrom("dhrmstn11@gmail.com", "������");
			sendMail.setTo(vo.getUser_email());
			sendMail.send();
		}else if(type.equals("partner")) {
			MailHandler sendMail = new MailHandler(mailSender);
			sendMail.setSubject("[ConnecTrip ����� ���� �̸���]");
			sendMail.setText(
					new StringBuffer().append("<h1>����ڴ� ������ ������ �̿밡���մϴ�</h1>").toString());
			sendMail.setFrom("dhrmstn11@gmail.com", "������");
			sendMail.setTo(vo.getUser_email());
			sendMail.send();
		}
		return 1;
	}
	
	public int changePwdMail(User_InfoVo vo) throws Exception{
		System.out.println(vo.getUser_email());
		System.out.println(vo.getUser_id());
		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[ConnecTrip ��й�ȣ ����]");
		sendMail.setText(
				new StringBuffer().append("<h3>��й�ȣ ����</h3>").append("<a href='http://localhost:8081/tour/changePwdPage?user_email=").append(vo.getUser_email()).append("&user_id=").append(vo.getUser_id()).append("' target='_blenk'>��й�ȣ ����</a>").toString());
		sendMail.setFrom("dhrmstn11@gmail.com", "������");
		sendMail.setTo(vo.getUser_email());
		sendMail.send();
		return 1;
	}
	
	public int adminEmailSend(String user_id,String contents) throws Exception{
		String user_email=dao.getEmail(user_id);
		MailHandler sendMail=new MailHandler(mailSender);
		System.out.println("user_email");
		System.out.println("contents");
		sendMail.setSubject("[ConnecTrip ��Ʈ�� �̸���]");
		sendMail.setText(
				new StringBuffer().append(contents.replaceAll("\\n", "<br>")).toString());
		sendMail.setFrom("dhrmstn11@gmail.com", "������");
		sendMail.setTo(user_email);
		sendMail.send();
		
		return 1;
	}
	
	public MemberUserDetail userDetail(String user_id) {
		return dao.getAuthsList(user_id);
	}
	
	
	public void userAuth(String user_email) throws Exception {
		dao.userAuth(user_email);
	}
	
	public void stateUp(String user_email) {
		 dao.stateUp(user_email);
	}
	
	public List<User_InfoVo> findid(String user_email){
		return dao.findid(user_email);
	}
	
	public void changePwd(String user_email,String user_pass) {
		User_InfoVo vo = new User_InfoVo();
		
		vo.setUser_email(user_email);
		vo.setUser_pass(encoder.encode(user_pass));
		dao.changePwd(vo);
	}
	
	public void dropUser(String user_id) {
		dao.dropUser(user_id);
		
	}
	
	public List<String> ptnSearch(){
		return dao.ptnSearch();
	}
}
