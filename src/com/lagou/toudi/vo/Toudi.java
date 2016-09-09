package com.lagou.toudi.vo;

import java.util.Date;

import com.lagou.companymgr.bind.dao.vo.Bind;
import com.lagou.jianli.jianli.vo.Jianli;

public class Toudi {
	private int id;
	private int jid;
	private int bid;
	private Date date;
	private int state;
	
	private Jianli j;
	private Bind b;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Jianli getJ() {
		return j;
	}
	public void setJ(Jianli j) {
		this.j = j;
	}
	public Bind getB() {
		return b;
	}
	public void setB(Bind b) {
		this.b = b;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
	
}
