package com.lagou.jianli.expectjob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.expectjob.dao.ExpectjobMapper;
import com.lagou.jianli.expectjob.vo.Expectjob;

@Service
public class ExpectjobService {
	@Autowired
	private ExpectjobMapper edao;
	@Transactional
	public void add(Expectjob ej){
		edao.add(ej);
	}
	
	public Expectjob query(int id){
		return edao.query(id);
	}
}
