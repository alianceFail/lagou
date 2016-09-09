package com.lagou.companymgr.reported.dao;

import java.util.List;

import com.lagou.companymgr.reported.vo.Reported;

public interface ReportMapper {
	public void add(Reported r);
	public List<Reported> query(int cid);
}
