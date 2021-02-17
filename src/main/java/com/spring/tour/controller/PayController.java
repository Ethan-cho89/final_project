package com.spring.tour.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.tour.service.PaymentService;
import com.spring.tour.vo.PaymentVo;


@Controller
public class PayController {
	
	@Autowired
	private PaymentService service;
	
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
					@RequestParam(value="count", defaultValue = "1") List<Integer> optionCnts,
					@RequestParam(value="optionPrice") List<Integer> optionPrice,
					Model model
			) {
		System.out.println("user_id ���� ��Ʈ�ѷ� : "+user_id);
		if(!user_id.equals("none")) {
			PaymentVo vo = service.getUserInfo(user_id);
			model.addAttribute("pvo", vo);
		}
		
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
		model.addAttribute("optionName",optionName);
		model.addAttribute("optionCnts",optionCnts);
		model.addAttribute("optionPrice",optionPrice);
		
//		System.out.println("service_name"+service_name);
//		System.out.println("cate_number"+cate_number);
//		System.out.println("service_number"+service_number);
//		System.out.println("user_id"+user_id);
//		for(int i : indexNum ) {
//			System.out.println("indexNum :"+i);
//		}
//		for(String i : optionName ) {
//			System.out.println("optionName :"+i);
//		}
//		for(int i : optionCnts ) {
//			System.out.println("optionCnts :"+i);
//		}
//		for(int i : optionPrice ) {
//			System.out.println("optionPrice :"+i);
//		}
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
						@RequestParam(value="pointUsing") int pointUsing,
						@RequestParam(value="thePrice") int thePrice,
						@RequestParam(value="waytopay") String waytopay,
						@RequestParam(value="agreecheck") List<String> agreecheckList) {

		//�ɼ� �ε��� + �ε����� ����
//		System.out.println("user_id"+user_id);
//		System.out.println("cate_number"+cate_number);
//		System.out.println("service_number"+service_number);
//		System.out.println("service_name"+service_name);
//		System.out.println("startDate"+startDate);
//		System.out.println("endDate"+endDate);
//		System.out.println("bookerName"+bookerName);
//		System.out.println("bookerPhone"+bookerPhone);
//		System.out.println("visitorName"+visitorName);
//		System.out.println("visitorPhone"+visitorPhone);
//		System.out.println("visitorEmail"+visitorEmail);
//		System.out.println("couponUsing"+couponUsing);
//		System.out.println("pointUsing"+pointUsing);
//		System.out.println("thePrice"+thePrice);
//		System.out.println("waytopay"+waytopay);
//		for(int oi : eachOptionIndex){
//			System.out.println("eachOptionIndex"+ oi); 
//		}
//		for(int oc : eachOptionCount){
//			System.out.println("eachOptionCount"+oc);
//		}
//		for(String s : agreecheckList){
//			System.out.println("agreecheckList"+s); // no3�� ���� ���� ����
//		}
//		for(int i=0; i<eachOptionIndex.size(); i++) {
//			System.out.println("tour_option_index :" + eachOptionIndex.get(i));
//			System.out.println("cnt : "+ eachOptionCount.get(i));
//		}
		
		
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
			
			if(!couponUsing.equals("none")) { 
				upMap.put("user_id", user_id);
				upMap.put("couponUsing", couponUsing);
			}
			if(pointUsing!=0) {// ����Ʈ ��� ���ϸ� ���� ���ϱ�
				upMap.put("user_id", user_id);
				upMap.put("pointUsing", pointUsing);
			}
			
			tboMap.put("service_number", service_number);
			tboMap.put("eachOptionIndex", eachOptionIndex);
			tboMap.put("eachOptionCount", eachOptionCount);
			
			int n = service.transactionTour(tbMap,upMap,tboMap); 
			System.out.println("�����̸� n=1 : " +n);
			
			}catch(ParseException pe) {
				pe.printStackTrace();
			}
		}else if(cate_number==2) {
			//���⿣ ����book �����ڵ�
		}
		return ".home";

	}
}
