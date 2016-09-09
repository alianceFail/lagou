package com.lagou.companymgr.job.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.companymgr.job.dao.dao.JobMapper;
import com.lagou.companymgr.job.dao.vo.Job;


@Service
public class JobService {

	@Autowired
	private JobMapper jdao;
	
	
	@Transactional
	public boolean add(Job j) {
		System.out.println("service");
            jdao.add(j);
			return true;
	}

	
    public List<Job> query0(){
		
		return jdao.query0();
	
	}
	public List<Job> query1(){
			
			return jdao.query1();
		
	}
	@Transactional
	public boolean updatexiaxian(int id)
	{
		jdao.updatexiaxian(id);
		return true;
	}
	@Transactional
	public boolean del(int id)
	{
		jdao.del(id);
		return true;
	}
	@Transactional
	public boolean updateshangxian(int id)
	{
		jdao.updateshangxian(id);
		return true;
	}
	
	public int countjob0()
	{
		return jdao.countjob0();
        
	}
	
	public int countjob1()
	{
		return jdao.countjob1();
	}
	
	public boolean updatejob(Job j)
	{
		jdao.updatejob(j);
		return true;
	}
	
	public Job queryjob(int id)
	{
		return jdao.queryjob(id);
	}
	
	public List<Job> querybyjob(Job j)
	{
		return jdao.querybyjob(j);
	}
	
	public List<Job> queryAll(){
		return jdao.queryAll();
	}
	
	
	
	
};
