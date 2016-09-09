package com.lagou.companymgr.company.dao.dao;

import com.lagou.companymgr.company.dao.vo.Company;

public interface CompanyMapper {
    public void add(Company c);
    public void update(Company c);
    public Company query(int lid);
    
    public void updateMid(Company c);
    
    public Company queryById(int id);
    
    
    
}