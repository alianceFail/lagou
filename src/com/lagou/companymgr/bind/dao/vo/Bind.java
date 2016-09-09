package com.lagou.companymgr.bind.dao.vo;

import java.util.Date;

import com.lagou.companymgr.company.dao.vo.Company;

public class Bind {
private Integer id;
private String holeName;
private String tel;
private String email;
private Date time;
private int cid;
private Company c;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}
public Company getC() {
	return c;
}
public void setC(Company c) {
	this.c = c;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getHoleName() {
	return holeName;
}
public void setHoleName(String holeName) {
	this.holeName = holeName;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}


}
