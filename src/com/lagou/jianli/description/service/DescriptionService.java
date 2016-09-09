package com.lagou.jianli.description.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.description.dao.DescriptionMapper;
import com.lagou.jianli.description.vo.Description;

@Service
public class DescriptionService {
	@Autowired
	private DescriptionMapper ddao;
	@Transactional
	public void add(Description d){
		ddao.add(d);
	}
	
	public Description query(int id){
		return ddao.query(id);
	}
	
	
	
}
