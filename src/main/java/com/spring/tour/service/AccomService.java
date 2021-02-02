package com.spring.tour.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.tour.dao.AccomDao;
import com.spring.tour.vo.Accom_serviceVo;

@Service
public class AccomService {
	@Autowired
	private AccomDao dao;
	
	public List<Accom_serviceVo> accom_service_list(HashMap<String, Object> map){
		return dao.accom_service_list(map);
	}
	public int accom_minprice(int serviceNum) {
		return dao.accom_minprice(serviceNum);
	}
}
