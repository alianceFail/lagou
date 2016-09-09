package com.lagou.companymgr.product.dao;

import java.util.List;

import com.lagou.companymgr.product.vo.Product;

public interface ProductMapper {
	public void add(Product p);
	
	public List<Product> queryByCid(int cid);
}
