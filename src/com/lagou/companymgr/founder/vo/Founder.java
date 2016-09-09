package com.lagou.companymgr.founder.vo;

import com.lagou.companymgr.company.dao.vo.Company;

public class Founder {
	private int id;
	private String name;
	private String 	position;
	private String weibo;
	private String remark;
	private int cid;
	private String founderphoto;
	
	
	public String getFounderphoto() {
		return founderphoto;
	}
	public void setFounderphoto(String founderphoto) {
		this.founderphoto = founderphoto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
}
