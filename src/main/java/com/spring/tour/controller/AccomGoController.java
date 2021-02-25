package com.spring.tour.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spring.tour.service.AccomService;
import com.spring.tour.service.TourPageService;
import com.spring.tour.vo.AccomInfoVo;
import com.spring.tour.vo.Accom_serviceVo;
import com.spring.tour.vo.ImageVo;
import com.spring.tour.vo.WishlistVo;

@Controller
public class AccomGoController {
	
	@Autowired
	private AccomService service;
	@Autowired
	private TourPageService tservice;
	
	@RequestMapping(value="/accomlist")
	public String goAccomSelect() {
		return ".accom.accomSelect";
	}
	
	@RequestMapping("/accomDetail")
	public String accomDetail(int accomNum,int cate_number,
			@RequestParam(value="startDate",required = false)String startDate,
			@RequestParam(value="endDate",required = false)String endDate,
			@RequestParam(value="count",defaultValue = "1")String count,
			Model model) {
		//�׽�Ʈ�� ���ǿ� ���̵� ���
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		
		//���ø���Ʈ ����ִ��� Ȯ�ο���
		HashMap<String, Object> map=new HashMap<String, Object>();
		String user_id=(String)session.getAttribute("user_id");
		map.put("user_id", user_id);
		map.put("cate_number", cate_number);
		map.put("service_number", accomNum);
		
		WishlistVo vo= tservice.tourDetailIsinWish(map);
		if(vo==null || vo.getUser_id().equals("")) {
			model.addAttribute("wishlist", false);
		}else {
			model.addAttribute("wishlist", true);
		}
		
		
		
		//������ ������ ��������
		
		AccomInfoVo infoVo=service.accomInfo(accomNum);
		Accom_serviceVo serviceVo=service.accomService(accomNum);
		infoVo.setAccom_info_content(infoVo.getAccom_info_content().replace("\\n","<br>"));
		infoVo.setAccom_how(infoVo.getAccom_how().replaceAll("\\n","<br>"));
		infoVo.setAccom_rule(infoVo.getAccom_rule().replaceAll("\\n", "<br>"));
		infoVo.setAccom_chekinfo(infoVo.getAccom_chekinfo().replaceAll("\\n", "<br>"));
		String conven[]=infoVo.getConven().split(",");
		String facility[]=infoVo.getFacility().split(",");
		model.addAttribute("info", infoVo);
		model.addAttribute("service", serviceVo);
		model.addAttribute("accomNum", accomNum);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		model.addAttribute("count", count);
		model.addAttribute("conven", conven);
		model.addAttribute("facility", facility);
		
		//���� ��ü�̹��� �ҷ�����
		List<ImageVo> wholeImage=service.accomWholeImage(accomNum);
		model.addAttribute("wholeImage",wholeImage);
		
		//������ ���� ��������
		int starPoint=service.accomStarPoint(map);
		model.addAttribute("avgpoint", starPoint);
		
		return ".accom.accomDetail";
	}
}
