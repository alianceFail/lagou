package com.lagou.jianli.description.dao;

import com.lagou.jianli.description.vo.Description;

public interface DescriptionMapper {
	public void add(Description d);
	
	public Description query(int id);
}
