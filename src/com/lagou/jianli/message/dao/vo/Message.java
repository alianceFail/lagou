package com.lagou.jianli.message.dao.vo;

public class Message
{
	private int id;//主键
	private String name;//名字
	private int  gender;//性别
	private String topDegree;//学历
	private String workyear;//工作年龄
	private String tel;//电话
	private String email;//邮箱
	private String currentState;//状态
	private String photo;
	
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getTopDegree() {
		return topDegree;
	}
	public void setTopDegree(String topDegree) {
		this.topDegree = topDegree;
	}
	public String getWorkyear() {
		return workyear;
	}
	public void setWorkyear(String workyear) {
		this.workyear = workyear;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCurrentState() {
		return currentState;
	}
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
