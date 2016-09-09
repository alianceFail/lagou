package com.lagou.companymgr.bind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.bind.dao.dao.BindMapper;
import com.lagou.companymgr.bind.dao.vo.Bind;

@Service
public class BindService {
	@Autowired
	private BindMapper bdao;
	
	@Transactional
	public boolean addbind(Bind b) {
            bdao.addbind(b);
			return true;
	}
	public boolean delbind(int id) {
        bdao.delbind(id);
		return true;
}
}
