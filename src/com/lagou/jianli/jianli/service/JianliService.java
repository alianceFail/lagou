package com.lagou.jianli.jianli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.jianli.dao.JianliMapper;
import com.lagou.jianli.jianli.vo.Jianli;

@Service
public class JianliService {
	@Autowired
	private JianliMapper jdao;
	@Transactional
	public void add(Jianli j){
		jdao.add(j);
	}
	
	public Jianli query(int lid){
		return jdao.query(lid);
	}
	@Transactional
	public void update(Jianli j){
		jdao.update(j);
	}
	@Transactional
	public void updateMid(Jianli j){
		jdao.updateMid(j);
	}
	@Transactional
	public void updateFid(Jianli j){
		jdao.updateFid(j);
	}
	@Transactional
	public void updateWid(Jianli j){
		jdao.updateWid(j);
	}
	@Transactional
	public void updatePid(Jianli j){
		jdao.updatePid(j);
	}
	@Transactional
	public void updateEid(Jianli j){
		jdao.updateEid(j);
	}
	@Transactional
	public void updateDid(Jianli j){
		jdao.updateDid(j);
	}
	@Transactional
	public void updateWsid(Jianli j){
		jdao.updateWsid(j);
	}
	@Transactional
	public void updateJianli(Jianli j){
		jdao.updateJianli(j);
	}
	@Transactional
	public Jianli queryid(int id){
		return jdao.queryid(id);
	}
	
}
