package com.spring.tour.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.tour.vo.ImageVo;
import com.spring.tour.vo.ReviewVo;
import com.spring.tour.vo.TourDetailVo;
import com.spring.tour.vo.TourOptionVo;
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
	
	public List<WishlistVo> tourSelectList(HashMap<String, Object> map){
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
	public List<ReviewVo> tourReviewList(HashMap<String, Object> map){
		return sqlsession.selectList(NAMESPACE+".tour_review_list",map);
	}
	//���� ���� �̹���
	public String tourReviewImage(int general_number){
		return sqlsession.selectOne(NAMESPACE+".tour_review_image",general_number);
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
	public TourOptionVo getTourOption(HashMap<String, Object> map) {
		return sqlsession.selectOne(NAMESPACE+".get_tourService", map);
	}
	public TourServiceVo getTourService(int serviceNum) {
		return sqlsession.selectOne(NAMESPACE+".get_tour_detail", serviceNum);
	}
	public List<TourServiceVo> tourServiceForId(String user_id){
		return sqlsession.selectList(NAMESPACE+".tour_service_forId", user_id);
	}
}
