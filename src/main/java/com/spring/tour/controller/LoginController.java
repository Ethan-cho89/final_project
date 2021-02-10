package com.spring.tour.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.spring.tour.vo.User_InfoVo;

@Controller
@SessionAttributes("login")
public class LoginController {
	
	@Autowired
	private Login_Interface login_Interface;
	
	@RequestMapping("/login")
	public String login() {
		return ".userjoin .login";
	}
	
	//�α��� ó��
		@RequestMapping(value="/loginCheck")
		public ModelAndView loginCheck(@ModelAttribute User_InfoVo vo,HttpSession session) {
			
			boolean result = login_Interface.loginCheck(vo, session);
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName(".userjoin.successTest");
			
			if(result) {
				mav.addObject("msg","����");
			}else {
				mav.addObject("msg","����");
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
}
