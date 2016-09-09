package com.lagou.jianli.workshow.dao;

import com.lagou.jianli.workshow.vo.Worksshow;

public interface WorksshowMapper {
	public void add(Worksshow ws);
	
	public Worksshow query(int id);
	
}
