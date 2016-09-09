package com.lagou.toudi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.toudi.dao.ToudiMapper;
import com.lagou.toudi.vo.Toudi;

@Service
public class ToudiService {
	@Autowired
	private ToudiMapper tdao;
	@Transactional
	public void add(Toudi t){
		tdao.add(t);
	}
	
	@Transactional
	public List<Toudi> query0(){
		return tdao.query0();
	}
	
	@Transactional
	public List<Toudi> query1(){
		return tdao.query1();
	}
	
	@Transactional
	public List<Toudi> query2(){
		return tdao.query2();
	}
	
	@Transactional
	public List<Toudi> query3(){
		return tdao.query3();
	}
	
	public int count(int state){
		return tdao.count(state);
	}
	
	
}
