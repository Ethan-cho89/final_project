package com.spring.tour.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.tour.service.TourPageService;
import com.spring.tour.vo.TourSelectVo;


@Controller
public class TourSelectController {

	@Autowired	
	private TourPageService service;
	
	@RequestMapping(value = "/tourSelect")
	public String tourSelect(String tourType, Model model) {
		if(tourType!=null || !tourType.equals("")) {
			model.addAttribute("tourType",tourType);
		}
		return "/tourPage/tourSelect";
	}
	
	@RequestMapping(value = "/tourSelectList", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	@ResponseBody
	public HashMap<String, Object> tourSelect(
			@RequestParam(value ="startDate") Date startDate,
			@RequestParam(value = "endDate") Date endDate, 
			@RequestParam(value = "targetPoint", defaultValue = "0") double targetPoint, 
			@RequestParam(value = "targetPrice", defaultValue = "0") int targetPrice,
			@RequestParam(value = "tourType", defaultValue = "0") int tourType,//��ü, �׸���ũ , ���� ��� 
			@RequestParam(value = "classification", defaultValue = "1") int classification, // ���丹����, ���� �Ѽ� ���
			String keyword) {
		System.out.println("-----------------------------");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("keyword", keyword);
		map.put("classification",classification); // 1:��õ��  / 2:���丹���� / 3:���� ������ / 4:���� ������
		
		if(tourType!=0) { //0: ��ü
			map.put("tourType",tourType); //1 Ƽ��/�н�   , 2:�׸���ũ , 3:���/Ŭ���� , 4:����
		}
		if(targetPoint!=0) {
			map.put("targetPoint", targetPoint);
		}
		if(targetPrice!=0) {
			map.put("targetPrice", targetPrice);
		}
		
		List<TourSelectVo> list = service.tourSelectList(map);
		int maxprice = 0;
		int minprice = 10000000;
		for(TourSelectVo vo : list) {
			if(maxprice <vo.getTour_price()) {
				maxprice= vo.getTour_price();
			};
			if(minprice>vo.getTour_price()) {
				minprice=vo.getTour_price();
			}
		}

		
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("startDate",startDate);
		result.put("endDate",endDate);
		result.put("targetPoint",targetPoint);
		result.put("targetPrice",targetPrice);
		result.put("tourType",tourType);
		result.put("classification",classification);
		result.put("minprice",minprice); // ����Ʈ ���� ���� ������ ����
		result.put("maxprice",maxprice); // ����Ʈ ���� ���� ��� ����
		result.put("list",list);
		return result;
	}
}
