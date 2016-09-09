package com.lagou.companymgr.founder.dao;

import java.util.List;

import com.lagou.companymgr.founder.vo.Founder;

public interface FounderMapper {
	public void add(Founder f);
//	public List<Founder> queryByMid();
	public List<Founder> queryByCid(int cid);
}
