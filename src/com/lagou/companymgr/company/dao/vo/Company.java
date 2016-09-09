package com.lagou.companymgr.company.dao.vo;


import com.lagou.companymgr.companymessage.vo.Companymessage;
import com.lagou.companymgr.founder.vo.Founder;
import com.lagou.companymgr.label.dao.vo.Label;
import com.lagou.login.user.dao.vo.User;

public class Company {
   private int id;
   private int lid;
   private int mid;
   private String companyProfile;
   private Companymessage c;
   private User u;
   private Label l;
	private Founder f;
   
   
   
public User getU() {
	return u;
}
public void setU(User u) {
	this.u = u;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getCompanyProfile() {
	return companyProfile;
}
public void setCompanyProfile(String companyProfile) {
	this.companyProfile = companyProfile;
}
public Companymessage getC() {
	return c;
}
public void setC(Companymessage c) {
	this.c = c;
}
public Label getL() {
	return l;
}
public void setL(Label l) {
	this.l = l;
}
public Founder getF() {
	return f;
}
public void setF(Founder f) {
	this.f = f;
}





}