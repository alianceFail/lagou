package com.lagou.toudi.dao;

import java.util.List;

import com.lagou.toudi.vo.Toudi;

public interface ToudiMapper {
	public void add(Toudi t);
	public List<Toudi> query0();
	public List<Toudi> query1();//待定
	public List<Toudi> query2();//通知面试
	public List<Toudi> query3();//不合适
	public void del(int id);
	public int count(int state);
	
}
