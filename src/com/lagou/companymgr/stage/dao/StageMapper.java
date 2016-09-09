package com.lagou.companymgr.stage.dao;

import java.util.List;

import com.lagou.companymgr.stage.vo.Stage;

public interface StageMapper {
//	public void add(List<Stage> s);
//	public List<Stage> queryByMid();
	
	public void add(Stage s);
	public Stage query(int mid);
}
