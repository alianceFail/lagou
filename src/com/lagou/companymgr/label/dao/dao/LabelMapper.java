package com.lagou.companymgr.label.dao.dao;

import com.lagou.companymgr.label.dao.vo.Label;

public interface LabelMapper {
  
	public void add(Label l);
  
	 public Label queryByCompany(int cid);
}
