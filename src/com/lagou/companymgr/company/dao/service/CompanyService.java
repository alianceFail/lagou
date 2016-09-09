package com.lagou.companymgr.company.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.company.dao.dao.CompanyMapper;
import com.lagou.companymgr.company.dao.vo.Company;

@Service
public class CompanyService {
	@Autowired
	private CompanyMapper cdao;
	@Transactional
	public void update(Company c){
		cdao.update(c);
	}
	@Transactional
	public void add(Company c){
		cdao.add(c);
	}
	
	public Company query(int lid){
		return cdao.query(lid);
		
	}
	@Transactional
	public void updateMid(Company c){
		cdao.updateMid(c);
	}
	
	public Company queryById(int id){
		return cdao.queryById(id);
	}
	
	
	
}
