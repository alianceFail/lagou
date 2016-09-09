package com.lagou.jianli.educationbackground.dao;

import com.lagou.jianli.educationbackground.vo.Educationalbackground;


public interface EducationbackgroundMapper {
	public void add(Educationalbackground eg);
	
	public Educationalbackground query(int id);
}
