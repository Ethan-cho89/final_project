package com.spring.tour.controller;

import java.util.ArrayList;
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
import com.spring.tour.service.BookingService;
import com.spring.tour.service.TourPageService;
import com.spring.tour.util.PageUtil;
import com.spring.tour.vo.AccomBookVo;
import com.spring.tour.vo.AccomOptionVo;
import com.spring.tour.vo.ImageVo;
import com.spring.tour.vo.TourBookVo;
import com.spring.tour.vo.TourOptionVo;


@Controller
public class BookingCheckController {
	@Autowired
	private BookingService service;
	@Autowired
	private AccomService accomService;
	@Autowired
	private TourPageService tourService;
	
	@RequestMapping("/accomBookingCheck")
	public String accomBooking(@RequestParam(value ="pageNum",defaultValue = "1")int pageNum,
			Model model) {
		//�׽�Ʈ�� ���� ����
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_id","dd");
		
		//������ ���̵� ��������
		String user_id=(String)session.getAttribute("user_id");
		model.addAttribute("user_id", user_id);
		
		//����¡ó��
		int totalRowCount=service.accomCount(user_id);
		PageUtil pu=new PageUtil(pageNum, 5, 5, totalRowCount);
		int startRow=pu.getStartRow();
		int endRow=pu.getEndRow();
		
		//������,�������� �ְ� ���ฮ��Ʈ �̾ƿ���
		HashMap<String, Object> accomMap=new HashMap<String, Object>();
		accomMap.put("startRow", startRow);
		accomMap.put("endRow", endRow);
		accomMap.put("user_id", user_id);
		List<AccomBookVo> accomBookList=service.accomBookList(accomMap);
		
		
		//������ ���ҿ� �ش��ϴ� ������ �̾ƿ���
		List<List<ImageVo>> image=new ArrayList<List<ImageVo>>();
		List<AccomOptionVo> detail=new ArrayList<AccomOptionVo>();
		for(AccomBookVo vo:accomBookList) {
			int optNum=vo.getAccom_option_number();
			List<ImageVo> roomImage=accomService.accomRoomImage(optNum);
			image.add(roomImage);
			AccomOptionVo roomDetail=accomService.accomRoomDetail(optNum);
			detail.add(roomDetail);
		}
		
		model.addAttribute("bookingList", accomBookList);
		model.addAttribute("pu", pu);
		model.addAttribute("image", image);
		model.addAttribute("detail", detail);
		
		return ".booking.accomBooking";
	}
	
	@RequestMapping("/tourBookingCheck")
	public String tourBooking(@RequestParam(value ="pageNum",defaultValue = "1")int pageNum,
			Model model) {
		//�׽�Ʈ�� ���� ����
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_id","dd");
		
		//������ ���̵� ��������
		String user_id=(String)session.getAttribute("user_id");
		model.addAttribute("user_id", user_id);
		
		//����¡ó��
		int totalRowCount=service.tourCount(user_id);
		PageUtil pu=new PageUtil(pageNum, 5, 5, totalRowCount);
		int startRow=pu.getStartRow();
		int endRow=pu.getEndRow();
		
		//������,�������� �ְ� ���ฮ��Ʈ �̾ƿ���
		HashMap<String, Object> tourMap=new HashMap<String, Object>();
		tourMap.put("startRow", startRow);
		tourMap.put("endRow", endRow);
		tourMap.put("user_id", user_id);
		List<TourBookVo> tourBookList=service.tourBookList(tourMap);
		
		//�̹���,�����̸��� �̾ƿ���
		List<TourOptionVo> option=new ArrayList<TourOptionVo>();
		for(TourBookVo vo:tourBookList) {
			int optNum=vo.getTour_option_number();
			TourOptionVo ovo=tourService.getTourOption(optNum);
			option.add(ovo);
			//���񽺳ѹ��� �̹��� �̾ƿ���
			
		}
		
		model.addAttribute("bookingList", tourBookList);
		model.addAttribute("pu", pu);
		model.addAttribute("opiton", option);
		
		return ".booking.tourBooking";
	}
}
