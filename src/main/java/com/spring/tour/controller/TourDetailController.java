package com.spring.tour.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.tour.service.TourPageService;
import com.spring.tour.vo.TourDetailVo;
import com.spring.tour.vo.WishlistVo;


@Controller
public class TourDetailController {
	@Autowired
	private TourPageService service;

	
	// ���̵� ������, cate_number, service_number �Ѱܹޱ�
	@RequestMapping(value = "/tourDetail")
	public String tourDetail(int cate_number, int service_number, Model model, HttpServletRequest req) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String user_id = (String)req.getSession().getAttribute("user_id");
		
		map.put("user_id",user_id);
		map.put("cate_number",cate_number);
		map.put("service_number",service_number);
		
		TourDetailVo vo = service.tourDetailList(map);
		vo.setTour_how(vo.getTour_how().replace("\n", "<br>"));
		vo.setTour_rule(vo.getTour_rule().replace("\n","<br>"));
		
		model.addAttribute("detail", vo);
		model.addAttribute("option",service.tourOptionList(service_number));
		model.addAttribute("de_image",service.tourDetailImage(service_number));
		model.addAttribute("pa_image",service.tourDetailPamphlet(service_number));
		model.addAttribute("review",service.tourReviewList(map));
		
		WishlistVo wvo= service.tourDetailIsinWish(map);
		if(wvo==null || wvo.getUser_id().equals("")) {
			model.addAttribute("wishlist", false);
		}else {
			model.addAttribute("wishlist", true);
		}
		return ".tourPage.tourDetail";

	}
}
