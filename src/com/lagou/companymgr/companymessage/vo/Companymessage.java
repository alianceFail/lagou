package com.lagou.companymgr.companymessage.vo;

public class Companymessage {
	private int id;//主键
	private String holename;//全称
	private String name;//简称
	private String website ;//网址
	private String city;//城市
	private String industry;//行业
	private String scale;//规模
	private String radio;//阶段
	private String temptation;//简介
	private int sid;
	private String logo;
	
	
	
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHolename() {
		return holename;
	}
	public void setHolename(String holename) {
		this.holename = holename;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getTemptation() {
		return temptation;
	}
	public void setTemptation(String temptation) {
		this.temptation = temptation;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
