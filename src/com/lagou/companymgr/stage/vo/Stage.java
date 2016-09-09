package com.lagou.companymgr.stage.vo;

import java.util.List;

import com.lagou.companymgr.companymessage.vo.Companymessage;

public class Stage {
	public int id;
	public String invest;
	public String org;
	public Companymessage c;
	public int mid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInvest() {
		return invest;
	}
	public void setInvest(String invest) {
		this.invest = invest;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public Companymessage getC() {
		return c;
	}
	public void setC(Companymessage c) {
		this.c = c;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
}
