package com.spring.tour.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.tour.security.MemberService;
import com.spring.tour.vo.User_InfoVo;

@Controller
public class UserController {
	
	@Autowired private MemberService service;
	
	@PostMapping("")
	public String join(User_InfoVo vo,HttpServletRequest req) throws Exception{
		service.insert(vo, req);
		return "/main";
	}
	
	@GetMapping("/gojoin")
	public String gojoin(String usertype,Model model) {
		model.addAttribute("usertype",usertype);
		return ".userjoin.userinput";
	}
	
	@GetMapping("/userterms")
	public String userterms() {
		return ".userjoin.userterms";
	}
	@PostMapping("/userselect")
	public String userselect() {
		return ".userjoin.userselect";
	}
	
	@RequestMapping(value = "/userinput", method = RequestMethod.POST)
	public String RegisterPost(User_InfoVo vo, Model model, RedirectAttributes rttr, HttpServletRequest req, HttpSession session) throws Exception {
		
		service.insert(vo, req);
		rttr.addFlashAttribute("authmsg" , "���Խ� ����� �̸��Ϸ� �������ּ���");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
	public String emailConfirm(String user_email, Model model) throws Exception { // �̸�������
		System.out.println("��ȫ�̹ٺ�");
		service.stateUp(user_email);
		model.addAttribute("user_email", user_email);

		return "/userjoin/emailConfirm";
	}
	
	@RequestMapping(value="/findidBtn")
	public String findidBtn() {
		return ".userjoin.findId";
	}
	@RequestMapping(value="/findId", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public HashMap<String,Object> findid(String user_email) {
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("user_email", user_email);
		
		List<User_InfoVo> findVo = service.findid(user_email);
		ArrayList<String> user_id=new ArrayList<String>();
		for(User_InfoVo vo :findVo) {
			String dbEmail = vo.getUser_email();
			if(dbEmail.equals(user_email)) {
				user_id.add(vo.getUser_id());
			}else {}
		}
		map.put("user_id", user_id);
		return map;
	}
	
	@RequestMapping(value="/sendPwdEmail")
	public String sendPwdEmail(String user_email) throws Exception{
		User_InfoVo vo = new User_InfoVo();
		vo.setUser_email(user_email);
		service.changePwdMail(vo);
		return ".home";
	}
	
	@RequestMapping(value="/findPwdBtn")
	public String findPwd() {
		return ".userjoin.findPwd";
	}
}
