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
	
	//�α��� ó��
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
					mav.addObject("msg","���� ���� ��");
					session.setAttribute("user_id", vo.getUser_id());
				}else if(con.equals("0")){
					mav.addObject("msg","���� ���� �ȉ�");
				}else {
					mav.addObject("msg","Ż���� ȸ��");
				}
			}else {
				mav.addObject("msg","���� �ȉ���");
			}
				return mav;
			
		}
		
		//�α׾ƿ� ó��
		@RequestMapping("/logout")
		public ModelAndView logout(HttpSession session) {
			
			login_Interface.logout(session);
			ModelAndView mav = new ModelAndView();
			mav.setViewName(".userjoin.successTest");
			mav.addObject("msg", "logout");
			
			return mav;
		}
		
		//īī�� ��Ʈ�ѷ�
		@RequestMapping(value="/kakaologin",produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST})
		public String kakaoLogin(@RequestParam("code") String code, Model model, HttpSession session) {
			System.out.println("�α��� �Ҷ� �ӽ� �ڵ尪");
	        //īī�� Ȩ���������� ���� ��� �ڵ�
	        System.out.println(code);
	        System.out.println("�α��� �� �����");
	        
	        //īī�� rest api ��ü ����
	        Kakao_restAPI kr = new Kakao_restAPI();
	        //������� node�� �����
	        JsonNode node = kr.getAccessToken(code);
	        //����� ���
	        System.out.println(node);
	        //��� �ȿ� �ִ� access_token���� ���� ���ڿ��� ��ȯ
	        String token = node.get("access_token").toString();
	        //���ǿ� ����ش�.
	        session.setAttribute("token", token);
	        
	        return ".userjoin.kakaoTest";

		}
		
		@RequestMapping(value = "/kakaologout", produces = "application/json")
	    public String Logout(HttpSession session) {
	        //kakao restapi ��ü ����
	        Kakao_restAPI kr = new Kakao_restAPI();
	        //��忡 �α׾ƿ��� ������� ����� �Ű������� ���ǿ� �մ� token�� ������ ���ڿ��� ��ȯ
	        JsonNode node = kr.Logout(session.getAttribute("token").toString());
	        //��� �� ���
	        System.out.println("�α��� �� ��ȯ�Ǵ� ���̵� : " + node.get("id"));
	        return "redirect:/";
	    } 
}
