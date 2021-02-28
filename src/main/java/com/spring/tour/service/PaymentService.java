package com.spring.tour.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.tour.dao.PaymentDao;
import com.spring.tour.vo.PaymentVo;


@Service
public class PaymentService {
	@Autowired
	private PaymentDao dao;
	
	public PaymentVo getUserInfo(String user_id) {
		return dao.getUserInfo(user_id);
	}
	
	@Transactional
	public int transactionTour(HashMap<String, Object> tbMap,
								HashMap<String, Object> upMap,
								HashMap<String, Object> tboMap) {
		
		int service_number= (Integer)tboMap.get("service_number");
		List<Integer> eachOptionIndex = (List<Integer>)tboMap.get("eachOptionIndex");
		List<Integer> eachOptionCount = (List<Integer>)tboMap.get("eachOptionCount");
		
		// ���� ���̺� ����
		dao.insertTourBook(tbMap);
		
		// ���� ���̺� ������ ������ �ѹ� ��������
		int booknumber = dao.tourBookMax(); 
		
		// tour_book_option & tour_option ���̺��� ���� map
		HashMap<String, Object> map	 = new HashMap<String, Object>(); // 
		map.put("tour_book_number", booknumber);
		map.put("service_number",service_number);
		
		for(int i=0; i<eachOptionIndex.size(); i++) {
			map.put("tour_option_index", eachOptionIndex.get(i));
			map.put("cnt", eachOptionCount.get(i));
			dao.insertTourBookOption(map); // ���� ������ �����Ͽ� ����� �ɼ� �󼼳��� ����
			dao.updateTicket(map); // �ɼǺ��� �����ִ� Ƽ�� ���� ���� 
		}
		
		
		// �տ��� none�̶�� �ϸ� �ȳѱ�ϱ� ������ ����ִ�. �ٵ� ������� �ʴٸ�!
		// ���� ���� ���� ���̺��� coupon_usecondition ����
		if(!((String)upMap.get("coupon_usecondition")).isEmpty()) { 
			dao.updateCoupon(upMap);
		}
		// ����Ʈ ��������� user_info ���̺��� ����� ��ŭ�� ����Ʈ ����
		dao.updatePoint(upMap);
		
		String user_id = (String)tbMap.get("user_id");
		System.out.println("user_id : "+user_id);
		
		
		int sumTotal = dao.getAccomTotal(user_id) + dao.getTourTotal(user_id);
		String newGrade = "";
		if(sumTotal>100000) {
			newGrade = "Silver";
		}else if(sumTotal>300000) {
			newGrade = "Gold";
		}else if(sumTotal>800000) {
			newGrade = "Platinum";
		}else if(sumTotal>1000000) {
			newGrade = "VIP";
		}
		
		System.out.println("sumTotal ="+sumTotal);
		HashMap<String, Object> gradeMap = new HashMap<>();
		gradeMap.put("user_id", user_id);
		gradeMap.put("user_grade", newGrade);
		dao.changeGrade(gradeMap);
		return 1;
	}
	
	@Transactional
	public int transactionAccom(HashMap<String, Object> abMap,
								HashMap<String, Object> viMap,
								HashMap<String, Object> upMap) {
		// accom_book�� �ٷ� ����
		dao.insertAccomBook(abMap);
		
		// �� �ڵ尡 �Ϸ�Ǹ� ���������� booknumber ������ �� �ִ�
		int booknumber = dao.AccomBookMax();
		
		//viMap���� accom_book_number��� ������ ���� MAX ���� �־��ش�.
		viMap.put("accom_book_number", booknumber);
		dao.insertVisitorInfo(viMap);
		
		// ���� ���� ���� ���̺��� coupon_usecondition ����
		if(!((String)upMap.get("coupon_usecondition")).isEmpty()) { 
			dao.updateCoupon(upMap);
		}
		// ����Ʈ ��������� user_info ���̺��� ����� ��ŭ�� ����Ʈ ����
		dao.updatePoint(upMap);
		
		String user_id = (String)abMap.get("user_id");
		System.out.println("user_id : "+user_id);

		int sumTotal = dao.getAccomTotal(user_id) + dao.getTourTotal(user_id);
		String newGrade = "";
		if(sumTotal>100000) {
			newGrade = "SILVER";
		}else if(sumTotal>300000) {
			newGrade = "GOLD";
		}else if(sumTotal>800000) {
			newGrade = "PLATINUM";
		}else if(sumTotal>1000000) {
			newGrade = "VIP";
		}
		
		System.out.println("sumTotal ="+sumTotal);
		HashMap<String, Object> gradeMap = new HashMap<>();
		gradeMap.put("user_id", user_id);
		gradeMap.put("user_grade", newGrade);
		dao.changeGrade(gradeMap);
		return 1;
		
	}
}
