package com.spring.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.tour.service.AccomService;
import com.spring.tour.vo.AccomInfoVo;
import com.spring.tour.vo.AccomOptionVo;
import com.spring.tour.vo.Accom_serviceVo;

@Controller
public class AccomDetailController {
	@Autowired
	private AccomService service;
	
	@RequestMapping("/accomDetail")
	public String accomDetail(int accomNum,Model model) {
		//������ ������ ��������
		
		AccomInfoVo infoVo=service.accomInfo(accomNum);
		Accom_serviceVo serviceVo=service.accomService(accomNum);
		List<AccomOptionVo> optionVo=service.accomOption(accomNum);
		infoVo.setAccom_info_content(infoVo.getAccom_info_content().replace("\\n","<br>"));
		infoVo.setAccom_how(infoVo.getAccom_how().replace("\\n","<br>"));
		model.addAttribute("info", infoVo);
		model.addAttribute("service", serviceVo);
		model.addAttribute("options", optionVo);
		
		//���� ��ü�̹���, �� ���� �̹����� �ҷ�����
		
		return "/accom/accomDetail";
	}
}
