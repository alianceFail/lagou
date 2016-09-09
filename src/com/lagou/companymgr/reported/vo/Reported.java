package com.lagou.companymgr.reported.vo;

import com.lagou.companymgr.company.dao.vo.Company;

public class Reported {
	private int id;
	private String articleTitle;
	private String articleUrl;
	private int cid;
	private Company c;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleUrl() {
		return articleUrl;
	}
	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Company getC() {
		return c;
	}
	public void setC(Company c) {
		this.c = c;
	}
	
}
