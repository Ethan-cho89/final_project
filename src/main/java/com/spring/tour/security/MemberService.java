package com.spring.tour.security;

import javax.servlet.http.HttpServletRequest;

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
		dao.insert(avo);
		
		String key = new TempKey().getKey(50, false); // ����Ű ����

		dao.createAuthKey(vo.getUser_email(), key); // ����Ű DB����

		MailHandler sendMail = new MailHandler(mailSender);
		sendMail.setSubject("[ALMOM ���� �̸��� ����]");
		sendMail.setText(
				new StringBuffer().append("<h1>��������</h1>").append("<a href='http://localhost/user/emailConfirm?user_email=").append(vo.getUser_email()).append("&key=").append(key).append("' target='_blenk'>�̸��� ���� Ȯ��</a>").toString());
		sendMail.setFrom("ȣ��Ʈ �̸��� ���̵�", "�˸�������");
		sendMail.setTo(vo.getUser_email());
		sendMail.send();
		
		return 1;
	}
	
	public MemberUserDetail userDetail(String user_id) {
		return dao.getAuthsList(user_id);
	}
	
	
	public void userAuth(String userEmail) throws Exception {
		dao.userAuth(userEmail);
	}
}
