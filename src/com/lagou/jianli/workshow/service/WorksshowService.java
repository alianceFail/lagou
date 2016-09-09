package com.lagou.jianli.workshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.workshow.dao.WorksshowMapper;
import com.lagou.jianli.workshow.vo.Worksshow;

@Service
public class WorksshowService {
	@Autowired
	private WorksshowMapper wdao;
	@Transactional
	public void add(Worksshow ws){
		wdao.add(ws);
	}
	
	public Worksshow query(int id){
		return wdao.query(id);
	}
	
	
}
