package com.lagou.jianli.jobsub.dao.vo;

import java.util.Date;

public class Jobsub 
{
	private int id;
	private String email;
	private String sendMailPer;
	private String positionName;
	private String city;
	private String financeStage;
	private String industryField;
    private String salary;
    private int lid;
    private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSendMailPer() {
		return sendMailPer;
	}
	public void setSendMailPer(String sendMailPer) {
		this.sendMailPer = sendMailPer;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFinanceStage() {
		return financeStage;
	}
	public void setFinanceStage(String financeStage) {
		this.financeStage = financeStage;
	}
	public String getIndustryField() {
		return industryField;
	}
	public void setIndustryField(String industryField) {
		this.industryField = industryField;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
