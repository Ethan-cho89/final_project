package com.spring.tour.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.tour.vo.ImageVo;
import com.spring.tour.vo.TourDetailVo;
import com.spring.tour.vo.TourOptionVo;
import com.spring.tour.vo.TourReviewVo;
import com.spring.tour.vo.TourSelectVo;
import com.spring.tour.vo.TourServiceVo;
import com.spring.tour.vo.WishlistVo;



@Repository
public class TourPageDao {
	@Autowired
	private SqlSession sqlsession;
	
	private final String NAMESPACE = "com.spring.tour.mapper.TourPageMapper";

	//////////////////////////////////////////
	//���� ù������ ������ 
	public List<TourSelectVo> tourMainList(){
		return sqlsession.selectList(NAMESPACE+".mainlist");
	}
	
	/////////////////////////////////////////
	//���� ���� ������ ������
	
	public List<TourSelectVo> tourSelectList(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".selectlist", map);
	}
	
	
	
	//////////////////////////////////////////////
	//���� �� ������ ������
	public TourDetailVo tourDetailList(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".detaillist", map);
	}
	//���� �ɼ� ���� ����Ʈ
	public List<TourOptionVo> tourOptionList(int service_number){
		return sqlsession.selectList(NAMESPACE+".tour_option_list",service_number);
	}
	//���� ���� ���� ����Ʈ(cate_number, service_number)
	public List<TourReviewVo> tourReviewList(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".tour_review_list",map);
	}	
	//���� ��Ȳ ������ ����Ʈ
	public List<ImageVo> tourDetailImage(int service_number){
		return sqlsession.selectList(NAMESPACE+".tour_detail_image",service_number);
	}
	//���� ������ ���� ���ø�
	public List<ImageVo> tourDetailPamphlet(int service_number){
		return sqlsession.selectList(NAMESPACE+".tour_detail_pamphlet",service_number);
	}
	
	public WishlistVo tourDetailIsinWish(HashMap<String, Object> map){
		return sqlsession.selectOne(NAMESPACE+".tour_detail_isinwish",map);
	}
	//���� �ɼǹ�ȣ�� �ش��ϴ� ����
	public TourOptionVo getTourOption(int optNum) {
		return sqlsession.selectOne(NAMESPACE+".get_tourService", optNum);
	}
	public TourServiceVo getTourService(int serviceNum) {
		return sqlsession.selectOne(NAMESPACE+".get_tour_detail", serviceNum);
	}
}
