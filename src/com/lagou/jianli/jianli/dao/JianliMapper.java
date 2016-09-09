package com.lagou.jianli.jianli.dao;

import com.lagou.jianli.jianli.vo.Jianli;

public interface JianliMapper {
	public void add(Jianli j);
	public Jianli query(int lid);
	public void update(Jianli j);
	public void updateMid(Jianli j);
	public void updateFid(Jianli j);
	public void updateWid(Jianli j);
	public void updatePid(Jianli j);
	public void updateEid(Jianli j);
	public void updateDid(Jianli j);
	public void updateWsid(Jianli j);
	public void updateJianli(Jianli j);
	public Jianli queryid(int id);
	
	
}
