package com.lagou.companymgr.reported.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.reported.dao.ReportMapper;
import com.lagou.companymgr.reported.vo.Reported;

@Service
public class ReportService {
	@Autowired
	private ReportMapper rdao;
	@Transactional
	public void add(Reported r){
		rdao.add(r);
	}
	
	public List<Reported> query(int cid){
		return rdao.query(cid);
	}
}
