package com.spring.tour.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tour.dao.TourPageDao;
import com.spring.tour.vo.ImageVo;
import com.spring.tour.vo.ReviewVo;
import com.spring.tour.vo.TourDetailVo;
import com.spring.tour.vo.TourOptionVo;
import com.spring.tour.vo.TourReviewVo;
import com.spring.tour.vo.TourSelectVo;
import com.spring.tour.vo.TourServiceVo;
import com.spring.tour.vo.WishlistVo;


@Service
public class TourPageService {
	
	@Autowired
	private TourPageDao dao; 
	////////////////////////////////////
	//���� ���� ������ ������
	public List<TourSelectVo> tourMainList(){
		return dao.tourMainList();
	}
	
	/////////////////////////////////
	// ���� ���� ������ ������
	public List<WishlistVo> tourSelectList(HashMap<String, Object> map){
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
	public List<ReviewVo> tourReviewList(HashMap<String, Object> map){
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
	
	//���� �ɼǹ�ȣ,���񽺹�ȣ�� ���� ����
	public TourOptionVo getTourOption(HashMap<String, Object> map) {
		return dao.getTourOption(map);
	}
	public TourServiceVo getTourService(int serviceNum) {
		return dao.getTourService(serviceNum);
	}
	public List<TourServiceVo> tourServiceForId(String user_id){
		return dao.tourServiceForId(user_id);
	}
	/////////////////////////////////////////////////////////////
	
	
	
}
