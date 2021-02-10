package com.spring.tour.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tour.dao.TourPageDao;
import com.spring.tour.vo.ImageVo;
import com.spring.tour.vo.TourDetailVo;
import com.spring.tour.vo.TourOptionVo;
import com.spring.tour.vo.TourPageVo;
import com.spring.tour.vo.TourReviewVo;
import com.spring.tour.vo.TourSelectVo;
import com.spring.tour.vo.WishlistVo;


@Service
public class TourPageService {
	
	@Autowired
	private TourPageDao dao; 
	////////////////////////////////////
	//���� ���� ������ ������
	public List<TourPageVo> tourMainList(){
		return dao.tourMainList();
	}
	
	/////////////////////////////////
	// ���� ���� ������ ������
	public List<TourSelectVo> tourSelectList(HashMap<String, Object> map){
		return dao.tourSelectList(map);
	}
	
	
	
	///////////////////////////////////////////////////////////
	
	//���� �� ������ ������
	public TourDetailVo tourDetailList(HashMap<String, Object> map){
		return dao.tourDetailList(map);
	}
	//���� �ɼ� ���� ����Ʈ
	public List<TourOptionVo> tourOptionList(int service_number){
		return dao.tourOptionList(service_number);
	}
	//���� ���� ���� ����Ʈ(cate_number, service_number)
	public List<TourReviewVo> tourReviewList(HashMap<String, Object> map){
		return dao.tourReviewList(map);
	}
	
	//���� ��Ȳ ������ ����Ʈ
	public List<ImageVo> tourDetailImage(int service_number){
		return dao.tourDetailImage(service_number);
	}
	//���� ������ ���� ���ø�
	public List<ImageVo> tourDetailPamphlet(int service_number){
		return dao.tourDetailPamphlet(service_number);
	}
	//���� ������ ��ǰ�� ���ÿ� �ִ��� Ȯ��
	public WishlistVo tourDetailIsinWish(HashMap<String, Object> map){
		return dao.tourDetailIsinWish(map);
	}
	/////////////////////////////////////////////////////////////
	
	
	
}
