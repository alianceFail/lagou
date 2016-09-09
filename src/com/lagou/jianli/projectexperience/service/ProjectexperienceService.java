package com.lagou.jianli.projectexperience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.lagou.jianli.projectexperience.dao.ProjectexperienceMapper;
import com.lagou.jianli.projectexperience.vo.Projectexperience;

@Service
public class ProjectexperienceService {
	@Autowired
	private ProjectexperienceMapper pdao;
	@Transactional
	public void add(Projectexperience pe){
		pdao.add(pe);
	}
	
	public Projectexperience query(int id){
		return pdao.query(id);
	}
	
	
}
