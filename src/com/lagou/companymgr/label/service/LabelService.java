package com.lagou.companymgr.label.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.label.dao.dao.LabelMapper;
import com.lagou.companymgr.label.dao.vo.Label;

@Service
public class LabelService {
	@Autowired
	private LabelMapper ldao;
	
	@Transactional
	public void add(Label l)
	{
		ldao.add(l);
	}
	
	@Transactional
	public Label queryByCompany(int cid)
	{
		 return ldao.queryByCompany(cid);
		
	}

}
