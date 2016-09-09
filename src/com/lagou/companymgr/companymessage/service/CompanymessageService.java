package com.lagou.companymgr.companymessage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.companymessage.dao.CompanymessageMapper;
import com.lagou.companymgr.companymessage.vo.Companymessage;
@Service
public class CompanymessageService {
	
	@Autowired
	private CompanymessageMapper cmdao;
	@Transactional
	public boolean add(Companymessage c){
		cmdao.add(c);
		return true;
	}
	
	public Companymessage query(int id){
		return cmdao.query(id);
	}
}
