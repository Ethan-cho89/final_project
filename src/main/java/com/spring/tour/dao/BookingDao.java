package com.spring.tour.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.tour.vo.AccomBookVo;
import com.spring.tour.vo.TourBookVo;

@Repository
public class BookingDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.spring.tour.mapper.BookingMapper";
	
	public List<AccomBookVo> accomBookList(HashMap<String, Object> accomMap){
		return sqlSession.selectList(NAMESPACE+".accomBookingList", accomMap);
	}
	public int accomCount(String user_id) {
		return sqlSession.selectOne(NAMESPACE+".accomBookingCount", user_id);
	}
	//���� ���� ���
	public List<AccomBookVo> accompastList(HashMap<String, Object> accomMap){
		return sqlSession.selectList(NAMESPACE+".accompastList", accomMap);
	}
	public int accompastCount(String user_id) {
		return sqlSession.selectOne(NAMESPACE+".accompastCount", user_id);
	}
	//���� ��Ҹ��
	public List<AccomBookVo> accomCancleList(String user_id){
		return sqlSession.selectList(NAMESPACE+".accomCancleList", user_id);
	}
	
	
	public List<TourBookVo> tourBookList(HashMap<String, Object> tourMap){
		return sqlSession.selectList(NAMESPACE+".tourBookingList", tourMap);
	}
	public int tourCount(String user_id) {
		return sqlSession.selectOne(NAMESPACE+".tourBookingCount", user_id);
	}
	//���� ������
	public List<TourBookVo> tourpastList(HashMap<String, Object> tourMap){
		return sqlSession.selectList(NAMESPACE+".tourpastList", tourMap);
	}
	public int tourpastCount(String user_id) {
		return sqlSession.selectOne(NAMESPACE+".tourpastCount", user_id);
	}
	//���� ��Ҹ��
	public List<TourBookVo> tourCancleList(String user_id){
		return sqlSession.selectList(NAMESPACE+".tourCancleList", user_id);
	}
}
