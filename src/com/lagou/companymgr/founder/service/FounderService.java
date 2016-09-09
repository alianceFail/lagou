package com.lagou.companymgr.founder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.founder.dao.FounderMapper;
import com.lagou.companymgr.founder.vo.Founder;

@Service
public class FounderService {
	
	@Autowired
	private FounderMapper fdao;
	@Transactional
	public void add(Founder f){
		fdao.add(f);
	}
	
	public List<Founder> queryByCid(int cid){
		return fdao.queryByCid(cid);
	}
}
