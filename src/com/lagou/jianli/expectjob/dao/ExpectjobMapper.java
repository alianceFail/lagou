package com.lagou.jianli.expectjob.dao;

import com.lagou.jianli.expectjob.vo.Expectjob;

public interface ExpectjobMapper {
	public void add(Expectjob ej);
	
	public Expectjob query(int id);
}
