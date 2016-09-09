package com.lagou.companymgr.product.vo;

import com.lagou.companymgr.company.dao.vo.Company;

public class Product {
	private int id;
	private String product;
	private String producturl;
	private String productprofile;
	private Company c;
	private int cid;
	private String productphoto;
	
	
	public String getProductphoto() {
		return productphoto;
	}
	public void setProductphoto(String productphoto) {
		this.productphoto = productphoto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProducturl() {
		return producturl;
	}
	public void setProducturl(String producturl) {
		this.producturl = producturl;
	}
	public String getProductprofile() {
		return productprofile;
	}
	public void setProductprofile(String productprofile) {
		this.productprofile = productprofile;
	}
	public Company getC() {
		return c;
	}
	public void setC(Company c) {
		this.c = c;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
