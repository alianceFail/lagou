package com.lagou.companymgr.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.product.dao.ProductMapper;
import com.lagou.companymgr.product.vo.Product;

@Service
public class ProductService {
	@Autowired
	private ProductMapper pdao;
	@Transactional
	public void add(Product p){
		pdao.add(p);
	}

	public List<Product> queryByCid(int cid){
		return pdao.queryByCid(cid);
	}

}
