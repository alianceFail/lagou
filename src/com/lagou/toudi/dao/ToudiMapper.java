package com.lagou.toudi.dao;

import java.util.List;

import com.lagou.toudi.vo.Toudi;

public interface ToudiMapper {
	public void add(Toudi t);
	public List<Toudi> query0();
	public List<Toudi> query1();//����
	public List<Toudi> query2();//֪ͨ����
	public List<Toudi> query3();//������
	public void del(int id);
	public int count(int state);
	
}
