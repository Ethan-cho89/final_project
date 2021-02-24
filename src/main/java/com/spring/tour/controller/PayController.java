package com.spring.tour.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.tour.service.PaymentService;
import com.spring.tour.service.TourPageService;
import com.spring.tour.vo.PaymentVo;
import com.spring.tour.vo.TourOptionVo;


@Controller
public class PayController {
	
	@Autowired
	private PaymentService service;
	
	@Autowired
	private TourPageService tpService;
	// ����� �����̶� �Ķ���� �̸� ���� ��Ű�� 
	/* service_name = ��ǰ�� / �����̸�
	 * cate_number = ī�װ��ѹ�
	 * service_number = ���񽺳ѹ�
	 * startDate = ��� ���� / ���ڿ� üũ��
	 * endDate = ����: ��ȿ�Ⱓ / ������ üũ�ƿ�
	 * userId = ����� ���̵�  --> ������� none���� ����
	 * service_options = ���̸�(��ȫ) / ���� �̸� 
	 * option_index = accom_option_number(��ȫ)/ tour_option_index(����)
	 * optionPrice 
	 */
	@RequestMapping(value = "/payment")
	public String payform(@RequestParam(value="serviceName") String service_name,
					@RequestParam(value="cateNumber") int cate_number,
					@RequestParam(value="serviceNumber") int service_number,
					@RequestParam(value="startDate", required = false) String startDate,
					@RequestParam(value="endDate", required = false) String endDate,
					@RequestParam(value="userId", defaultValue = "none") String user_id,
					@RequestParam(value="option_index") List<Integer> indexNum,
					@RequestParam(value="service_option") List<String> optionName,
					@RequestParam(value="count", defaultValue = "0") List<Integer> optionCnts,
					@RequestParam(value="optionPrice") List<Integer> optionPrice,
					@RequestParam(value="discount",required = false) String discount,
					Model model,
					HttpServletRequest req
			) {
		
		PaymentVo vo;
		if(!user_id.equals("none")) {
			if(req.getSession().getAttribute("user_id")!=null) {
				vo = service.getUserInfo((String)req.getSession().getAttribute("user_id"));
			}else {
				vo = service.getUserInfo(user_id);
			}
		}else {
			vo = service.getUserInfo((String)req.getSession().getAttribute("user_id"));
		}
		model.addAttribute("pvo", vo);
		
		model.addAttribute("service_name",service_name);
		model.addAttribute("cate_number",cate_number);
		model.addAttribute("service_number",service_number);
		if(startDate!=null) {
			model.addAttribute("startDate",startDate);
//			System.out.println("startDate"+startDate);
		}
		if(endDate!=null) {
			model.addAttribute("endDate",endDate);
//			System.out.println("endDate"+endDate);
		}
		
		model.addAttribute("user_id",user_id);
		model.addAttribute("indexNum",indexNum);
		
		
		List<TourOptionVo> tdList = tpService.tourOptionList(service_number);
		
		model.addAttribute("optionList",tdList);
		model.addAttribute("optionName",optionName);
		model.addAttribute("optionCnts",optionCnts);
		model.addAttribute("optionPrice",optionPrice);
		
		if(discount!=null) {
			model.addAttribute("discount", Integer.parseInt(discount));
		}
		return ".pay.payment";
	}
	
	/*
	 * bookerName = �����ڸ�
	 * bookerPhone = �����ڿ���ó
	 * visitorName = �����ڸ�
	 * visitorPhone= ������ ����ó
	 * couponUsing = ����ϴ� ������ �̸�
	 * pointUsing = ����� ����Ʈ  int 
	 * thePrice = ������ �ݾ� int 
	 * waytopay = ���� ���
	 * agreecheck = ���Ǽ� üũ no3���� Ȯ���ϸ� ��
	 * 
	 * 
	 */
	@RequestMapping(value = "/payit")
	public String payit(@RequestParam(value="user_id",required = false) String user_id,
						@RequestParam(value="cate_number") int cate_number,
						@RequestParam(value="service_number") int service_number,
						@RequestParam(value="service_name") String service_name,
						@RequestParam(value="bookerName") String bookerName,
						@RequestParam(value="bookerPhone") String bookerPhone,
						@RequestParam(value="startDate", required = false) String startDate,
						@RequestParam(value="endDate", required = false) String endDate,
						@RequestParam(value="eachOptionIndex") List<Integer> eachOptionIndex,
						@RequestParam(value="eachOptionCount") List<Integer> eachOptionCount,
						@RequestParam(value="visitorName",required = false) String visitorName,
						@RequestParam(value="visitorPhone",required = false) String visitorPhone,
						@RequestParam(value="visitorEmail",required = false) String visitorEmail,
						@RequestParam(value="couponUsing",required = false) String couponUsing,
						@RequestParam(value="pointUsing", defaultValue = "0") int pointUsing,
						@RequestParam(value="thePrice") int thePrice,
						@RequestParam(value="waytopay") String waytopay,
						@RequestParam(value="agreecheck") List<String> agreecheckList,
						HttpServletRequest req) {
		
		user_id=(String)req.getSession().getAttribute("user_id");
		
		if(cate_number ==1) {
			try {
			//���⿣ ����book ���� �ڵ�
			HashMap<String, Object> tbMap = new HashMap<String, Object>(); // tourBook
			HashMap<String, Object> tboMap = new HashMap<String, Object>(); // tourBookOption
			HashMap<String, Object> upMap = new HashMap<String, Object>(); // update�� �׳� ���� ����
			if(user_id!=null) {
				tbMap.put("user_id", user_id);
			}else {
				user_id="none"; //��ȸ���϶��� ���..
				tbMap.put("user_id", user_id);
			}
			tbMap.put("service_number", service_number);
			tbMap.put("service_name", service_name);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if(startDate!=null) { //���⼱ �ʿ� ���� �ڵ� 
				tbMap.put("tour_startdate", dateFormat.parse(startDate));
			}
			if(endDate!=null) {
				tbMap.put("tour_enddate", dateFormat.parse(endDate));
			}
			tbMap.put("payment_condition", "�����Ϸ�");
			tbMap.put("total_price", thePrice);
			tbMap.put("point_useamount", pointUsing); //0�� �׻� ���� ����ߴܸ� user_info ����Ʈ ������Ʈ!!!!
			
			if(!couponUsing.equals("none") || couponUsing!=null) {
				tbMap.put("coupon_usecondition", couponUsing); //����� ������ �̸��� �� ����ߴٸ� user_info�� ������Ʈ!!!
			}
			tbMap.put("payment_method", waytopay);
			tbMap.put("bookername", bookerName);
			tbMap.put("bookerphone", bookerPhone);
			
			// update ���� 
			if(!couponUsing.equals("none")) { 
				upMap.put("user_id", user_id);
				upMap.put("coupon_usecondition", couponUsing);
			}
			upMap.put("user_id", user_id);
			upMap.put("point_useamount", pointUsing);
			
			// tour_book_option ���� 
			tboMap.put("service_number", service_number);
			tboMap.put("eachOptionIndex", eachOptionIndex);
			tboMap.put("eachOptionCount", eachOptionCount);
			
			int n = service.transactionTour(tbMap,upMap,tboMap); 
			if(n>0) {
				System.out.println("����/Ƽ�� ���� ����");
			}
			
			}catch(ParseException pe) {
				pe.printStackTrace();
				return ".pay.payment";
			}
		}else if(cate_number!=1) {
			try {
		
			HashMap<String, Object> abMap = new HashMap<String, Object>(); // accom_Book
			HashMap<String, Object> viMap = new HashMap<String, Object>(); // visitor_info
			HashMap<String, Object> upMap = new HashMap<String, Object>(); // update�� �׳� ���� ����
			
			if(user_id!=null) {
				abMap.put("user_id", user_id);
			}else {
				user_id="none"; //��ȸ���϶��� ���..
				abMap.put("user_id", user_id);
			}
			abMap.put("user_id", user_id);
			abMap.put("optionNum", eachOptionIndex.get(0));
			abMap.put("service_name", service_name);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if(startDate!=null) {
				abMap.put("startDate", dateFormat.parse(startDate));
			}
			if(endDate!=null) {
				abMap.put("endDate", dateFormat.parse(endDate));
			}
			
			abMap.put("payment_condition","�����Ϸ�");
			abMap.put("total_price", thePrice);
			abMap.put("point_useamount", pointUsing);

			if(!couponUsing.equals("none") || couponUsing!=null) {
				abMap.put("coupon_usecondition", couponUsing); //����� ������ �̸��� �� ����ߴٸ� user_info�� ������Ʈ!!!
			}
			abMap.put("payment_method", waytopay);
			
			// #{accom_book_number}�� ���񽺿��� �߰����ش�.
			viMap.put("visitor_name", visitorName);
			viMap.put("visitor_email", visitorEmail);
			viMap.put("visitor_phone", visitorPhone);

			upMap.put("user_id", user_id);
			upMap.put("point_useamount", pointUsing);
			if(!couponUsing.equals("none") || couponUsing!=null) {
				upMap.put("coupon_usecondition", couponUsing);
			}
			///////////////
			
			int n = service.transactionAccom(abMap,viMap,upMap);
			if(n>0) {
				System.out.println("���� ���� ����");
			}
			
			}catch(ParseException pe) {
				pe.printStackTrace();
				return ".pay.payment"; //�̰� �ȸ����� �ڷΰ���
			}
		}
		return ".home";

	}
}
