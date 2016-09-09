package com.lagou.companymgr.stage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.stage.dao.StageMapper;
import com.lagou.companymgr.stage.vo.Stage;

@Service
public class StageService {
	@Autowired
	private StageMapper sdao;
//	
//	public void add(List<Stage> slist){
//		 
//		sdao.add(slist);
//	}
//	
//	public List<Stage> queryByMid(){
//		return sdao.queryByMid();
//	}
	@Transactional
	public void add(Stage s){
		sdao.add(s);
	}
	public Stage query(int mid){
		return sdao.query(mid);
	}
	
}
