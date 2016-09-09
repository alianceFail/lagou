package com.lagou.jianli.workexperience.dao;

import com.lagou.jianli.workexperience.vo.Workexperience;

public interface WorkexperienceMapper {
	public void add(Workexperience w);
	
	public Workexperience query(int id);

}
