package com.spring.tour.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.tour.security.MemberUserDetail;
import com.spring.tour.vo.IdTokenVo;
import com.spring.tour.vo.User_InfoVo;

@Repository
public class MemberDao {
	private final String NAMESPACE ="com.spring.tour.mapper.UserMapper";
	@Autowired
	private SqlSession sqlSession;
	
	public int insert(User_InfoVo vo) {
		System.out.println(vo);
		return sqlSession.insert(NAMESPACE+".user_insert",vo);
	}
	
	public int insert(IdTokenVo vo) {
		System.out.println(vo);
		return sqlSession.insert(NAMESPACE+".auth_insert",vo);
	}
	
	public MemberUserDetail getAuthsList(String user_id) {
		return sqlSession.selectOne(NAMESPACE+".getAuths",user_id);
	}
	
	public void createAuthKey(String user_email,String user_authCode) throws Exception{
		IdTokenVo vo = new IdTokenVo();
		vo.setToken_data(user_authCode);
		
		sqlSession.selectOne(NAMESPACE+".createAuthKey",vo);
	}
	
	public void userAuth(String user_email) throws Exception {
		sqlSession.update(NAMESPACE + ".userAuth", user_email);
	}
	
	public void stateUp(String user_email) {
		sqlSession.update(NAMESPACE+".stateUp",user_email);
	}
	
	public User_InfoVo loginCheck(User_InfoVo vo) {
		System.out.println("?α??Ή???");
		System.out.println(vo.getUser_id());
		return sqlSession.selectOne(NAMESPACE+".loginCheck",vo);
	}
	
	public void logout(HttpSession session) {
		System.out.println("?α׾ƿ? ????");
		session.invalidate();
	}
	
	public List<User_InfoVo> findid(String user_email) {
		return sqlSession.selectList(NAMESPACE+".findid",user_email);
	}
	
	public void changePwd(User_InfoVo vo) {
		sqlSession.update(NAMESPACE+".changePwd",vo);
	}
	
	public void dropUser(String user_id) {
		sqlSession.update(NAMESPACE+".dropUser",user_id);
	}
	public String checkId(String user_id) {
		return sqlSession.selectOne(NAMESPACE+".checkId",user_id);
	}
	public List<String> ptnSearch(String searchValue){
		return sqlSession.selectList(NAMESPACE+".ptnSearch",searchValue);
	}
	public String getEmail(String user_id) {
		return sqlSession.selectOne(NAMESPACE+".getEmail",user_id);
	}
}
