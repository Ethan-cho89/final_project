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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spring.tour.service.AccomService;
import com.spring.tour.service.BookingService;
import com.spring.tour.service.TourPageService;
import com.spring.tour.util.PageUtil;
import com.spring.tour.vo.AccomBookVo;
import com.spring.tour.vo.AccomOptionVo;
import com.spring.tour.vo.Accom_serviceVo;
import com.spring.tour.vo.ImageVo;
import com.spring.tour.vo.TourBookOptionVo;
import com.spring.tour.vo.TourBookVo;
import com.spring.tour.vo.TourOptionVo;
import com.spring.tour.vo.TourServiceVo;
import com.spring.tour.vo.VisitorInfoVo;


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
		session.setAttribute("user_id","ck");
		
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
		List<Accom_serviceVo> service=new ArrayList<Accom_serviceVo>();
		for(AccomBookVo vo:accomBookList) {
			int optNum=vo.getAccom_option_number();
			List<ImageVo> roomImage=accomService.accomRoomImage(optNum);
			image.add(roomImage);
			AccomOptionVo roomDetail=accomService.accomRoomDetail(optNum);
			detail.add(roomDetail);
			//ī�װ��ѹ� �̾ƿ���
			int accomNum=roomDetail.getAccom_service_number();
			Accom_serviceVo as=accomService.accomService(accomNum);
			service.add(as);
		}
		
		model.addAttribute("bookingList", accomBookList);
		model.addAttribute("pu", pu);
		model.addAttribute("image", image);
		model.addAttribute("detail", detail);
		model.addAttribute("service", service);
		
		return ".booking.accomBooking";
	}
	
	@RequestMapping("/tourBookingCheck")
	public String tourBooking(@RequestParam(value ="pageNum",defaultValue = "1")int pageNum,
			Model model) {
		//�׽�Ʈ�� ���� ����
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_id","ck");
		
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
		List<List<ImageVo>> image=new ArrayList<List<ImageVo>>();
		for(TourBookVo vo:tourBookList) {
			int service_number=vo.getService_number();
			//���񽺳ѹ��� �̹��� �̾ƿ���
			List<ImageVo> tourimg=tourService.tourDetailImage(service_number);
			image.add(tourimg);
		}
		
		model.addAttribute("bookingList", tourBookList);
		model.addAttribute("pu", pu);
		model.addAttribute("option", option);
		model.addAttribute("image", image);
		return ".booking.tourBooking";
	}
	
	//���� ���Ҹ��
	@RequestMapping("/accompastTrip")
	public String accompastTrip(@RequestParam(value ="pageNum",defaultValue = "1")int pageNum,
			Model model) {
		//�׽�Ʈ�� ���� ����
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_id","ck");
		
		//������ ���̵� ��������
		String user_id=(String)session.getAttribute("user_id");
		model.addAttribute("user_id", user_id);
		
		//����¡ó��
		int totalRowCount=service.accompastCount(user_id);
		PageUtil pu=new PageUtil(pageNum, 5, 5, totalRowCount);
		int startRow=pu.getStartRow();
		int endRow=pu.getEndRow();
		
		//������,�������� �ְ� ���ฮ��Ʈ �̾ƿ���
		HashMap<String, Object> accomMap=new HashMap<String, Object>();
		accomMap.put("startRow", startRow);
		accomMap.put("endRow", endRow);
		accomMap.put("user_id", user_id);
		List<AccomBookVo> accompastList=service.accompastList(accomMap);
		
		
		//������ ���ҿ� �ش��ϴ� ������ �̾ƿ���
		List<List<ImageVo>> image=new ArrayList<List<ImageVo>>();
		List<AccomOptionVo> detail=new ArrayList<AccomOptionVo>();
		List<Accom_serviceVo> service=new ArrayList<Accom_serviceVo>();
		for(AccomBookVo vo:accompastList) {
			int optNum=vo.getAccom_option_number();
			List<ImageVo> roomImage=accomService.accomRoomImage(optNum);
			image.add(roomImage);
			AccomOptionVo roomDetail=accomService.accomRoomDetail(optNum);
			detail.add(roomDetail);
			//ī�װ��ѹ� �̾ƿ���
			int accomNum=roomDetail.getAccom_service_number();
			Accom_serviceVo as=accomService.accomService(accomNum);
			service.add(as);
		}
		
		model.addAttribute("bookingList", accompastList);
		model.addAttribute("pu", pu);
		model.addAttribute("image", image);
		model.addAttribute("detail", detail);
		model.addAttribute("service",service);
		
		return ".booking.accompastTrip";
	}
	
	//���� ������
	@RequestMapping("/tourpastTrip")
	public String tourpastTrip(@RequestParam(value ="pageNum",defaultValue = "1")int pageNum,
			Model model) {
		//�׽�Ʈ�� ���� ����
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_id","ck");
		
		//������ ���̵� ��������
		String user_id=(String)session.getAttribute("user_id");
		model.addAttribute("user_id", user_id);
		
		//����¡ó��
		int totalRowCount=service.tourpastCount(user_id);
		PageUtil pu=new PageUtil(pageNum, 5, 5, totalRowCount);
		int startRow=pu.getStartRow();
		int endRow=pu.getEndRow();
		
		//������,�������� �ְ� ���ฮ��Ʈ �̾ƿ���
		HashMap<String, Object> tourMap=new HashMap<String, Object>();
		tourMap.put("startRow", startRow);
		tourMap.put("endRow", endRow);
		tourMap.put("user_id", user_id);
		List<TourBookVo> tourpastList=service.tourpastList(tourMap);
		
		//�̹���,�����̸��� �̾ƿ���
		List<TourOptionVo> option=new ArrayList<TourOptionVo>();
		List<List<ImageVo>> image=new ArrayList<List<ImageVo>>();
		for(TourBookVo vo:tourpastList) {
			int service_number=vo.getService_number();
			List<ImageVo> tourimg=tourService.tourDetailImage(service_number);
			image.add(tourimg);
		}
		
		model.addAttribute("bookingList", tourpastList);
		model.addAttribute("pu", pu);
		model.addAttribute("opiton", option);
		model.addAttribute("image", image);
		
		return ".booking.tourpastTrip";
	}
	
	@RequestMapping("/cancelTrip")
	public String cancelTrip(@RequestParam(value ="pageNum",defaultValue = "1")int pageNum,
			Model model) {
		//�׽�Ʈ�� ���� ����
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("user_id","ck");
		
		//������ ���̵� ��������
		String user_id=(String)session.getAttribute("user_id");
		model.addAttribute("user_id", user_id);
		
		//������,�������� �ְ� ���ฮ��Ʈ �̾ƿ���
		List<AccomBookVo> accomCancelList=service.accomCancelList(user_id);
		List<TourBookVo> tourCancelList=service.tourCancelList(user_id);
		
		
		//������ ���ҿ� �ش��ϴ� ������ �̾ƿ���
		List<List<ImageVo>> image=new ArrayList<List<ImageVo>>();
		List<AccomOptionVo> detail=new ArrayList<AccomOptionVo>();
		List<Accom_serviceVo> service=new ArrayList<Accom_serviceVo>();
		for(AccomBookVo vo:accomCancelList) {
			int optNum=vo.getAccom_option_number();
			List<ImageVo> roomImage=accomService.accomRoomImage(optNum);
			image.add(roomImage);
			AccomOptionVo roomDetail=accomService.accomRoomDetail(optNum);
			detail.add(roomDetail);
			//ī�װ��ѹ� �̾ƿ���
			int accomNum=roomDetail.getAccom_service_number();
			Accom_serviceVo as=accomService.accomService(accomNum);
			service.add(as);
		}
		
		//���� ������ �̾ƿ���
		List<TourOptionVo> option=new ArrayList<TourOptionVo>();
		List<List<ImageVo>> timage=new ArrayList<List<ImageVo>>();
		for(TourBookVo vo:tourCancelList) {
			int service_number=vo.getService_number();
			List<ImageVo> tourimg=tourService.tourDetailImage(service_number);
			timage.add(tourimg);
		}
		
		model.addAttribute("accomCancelList", accomCancelList);
		model.addAttribute("tourCancelList", tourCancelList);
		model.addAttribute("aimage", image);
		model.addAttribute("timage", timage);
		model.addAttribute("detail", detail);
		model.addAttribute("opiton", option);
		model.addAttribute("service", service);
		
		return ".booking.cancelTrip";
	}
	@RequestMapping("/accomCancel")
	public String accomCancel(int bookNumber,Model model) {
		try {
			HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			String user_id=(String)session.getAttribute("user_id");
			int n=service.accomCancel(bookNumber,user_id);
			model.addAttribute("result", "success");
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "fail");
		}
		return "redirect:/accomBookingCheck";
	}
	
	@RequestMapping("/tourCancel")
	public String tourCancel(int bookNumber,Model model) {
		try {
			HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			String user_id=(String)session.getAttribute("user_id");
			int n=service.tourCancel(bookNumber,user_id);
			model.addAttribute("result", "success");
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("result", "fail");
		}
		return "redirect:/tourBookingCheck";
	}
	
	@RequestMapping("/tourBookDetail")
	@ResponseBody
	public HashMap<String, Object> tourBookDetail(int bookNumber){
		List<TourBookOptionVo> tbo=service.tourBookOption(bookNumber);
		List<Integer> count=new ArrayList<Integer>();
		List<TourOptionVo> detail=new ArrayList<TourOptionVo>();
		String addr="";
		for(TourBookOptionVo vo:tbo) {
			int optNum=vo.getTour_option_index();
			int cnt=vo.getCnt();
			count.add(cnt);
			TourOptionVo optvo=tourService.getTourOption(optNum);
			detail.add(optvo);
			int serviceNum=optvo.getService_number();
			TourServiceVo tsv=tourService.getTourService(serviceNum);
			addr=tsv.getTour_addr();
		}
		HashMap<String, Object> result=new HashMap<String, Object>();
		result.put("count", count);
		result.put("detail", detail);
		result.put("addr", addr);
		return result;
	}
	
	@RequestMapping("/accomBookDetail")
	@ResponseBody
	public HashMap<String, Object> accomBookDetail(int bookNumber,int optNum){
		VisitorInfoVo viv=service.accomBookDetail(bookNumber);
		AccomOptionVo avo=accomService.accomRoomDetail(optNum);
		int serviceNum=avo.getAccom_service_number();
		Accom_serviceVo svo=accomService.accomService(serviceNum);
		HashMap<String, Object> result=new HashMap<String, Object>();
		result.put("visitor", viv);
		result.put("detail", avo);
		result.put("service",svo);
		return result;
	}
}
