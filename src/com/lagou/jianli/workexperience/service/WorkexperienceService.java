package com.lagou.jianli.workexperience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.workexperience.dao.WorkexperienceMapper;
import com.lagou.jianli.workexperience.vo.Workexperience;

@Service
public class WorkexperienceService {
	@Autowired
	private WorkexperienceMapper wdao;
	@Transactional
	public void add(Workexperience w){
		wdao.add(w);
	}
	
	public Workexperience query(int id){
		return wdao.query(id);
	}
}
