package com.lagou.jianli.educationbackground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.educationbackground.dao.EducationbackgroundMapper;
import com.lagou.jianli.educationbackground.vo.Educationalbackground;

@Service
public class EducationbackgroundService {
	@Autowired
	private EducationbackgroundMapper edao;
	@Transactional
	public void add(Educationalbackground eg){
		edao.add(eg);
	}
	
	public Educationalbackground query(int id){
		return edao.query(id);
	}
	
}
