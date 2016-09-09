package com.lagou.jianli.jianli.vo;

import java.util.Date;

import com.lagou.jianli.description.vo.Description;
import com.lagou.jianli.educationbackground.vo.Educationalbackground;
import com.lagou.jianli.expectjob.vo.Expectjob;
import com.lagou.jianli.message.dao.vo.Message;
import com.lagou.jianli.projectexperience.vo.Projectexperience;
import com.lagou.jianli.workexperience.vo.Workexperience;
import com.lagou.jianli.workshow.vo.Worksshow;

public class Jianli {
	private int id;
	private String title;
	private int lid;
	private int mid;
	private int fid;
	private int wid;
	private int pid;
	private int eid;
	private int did;
	private int wsid;
	private Date date;
	private int state;
	private String jianli;
	private String jianliUrl;
	
	private Message m;
	private Description d;
	private Educationalbackground ed;
	private Expectjob ej;
	private Projectexperience pj;
	private Workexperience we;
	private Worksshow ws;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getWsid() {
		return wsid;
	}
	public void setWsid(int wsid) {
		this.wsid = wsid;
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
	public Message getM() {
		return m;
	}
	public void setM(Message m) {
		this.m = m;
	}
	public Description getD() {
		return d;
	}
	public void setD(Description d) {
		this.d = d;
	}
	public Educationalbackground getEd() {
		return ed;
	}
	public void setEd(Educationalbackground ed) {
		this.ed = ed;
	}
	public Expectjob getEj() {
		return ej;
	}
	public void setEj(Expectjob ej) {
		this.ej = ej;
	}
	public Projectexperience getPj() {
		return pj;
	}
	public void setPj(Projectexperience pj) {
		this.pj = pj;
	}
	public Workexperience getWe() {
		return we;
	}
	public void setWe(Workexperience we) {
		this.we = we;
	}
	public Worksshow getWs() {
		return ws;
	}
	public void setWs(Worksshow ws) {
		this.ws = ws;
	}
	public String getJianli() {
		return jianli;
	}
	public void setJianli(String jianli) {
		this.jianli = jianli;
	}
	public String getJianliUrl() {
		return jianliUrl;
	}
	public void setJianliUrl(String jianliUrl) {
		this.jianliUrl = jianliUrl;
	}
	
	
	
	
	
	
}
