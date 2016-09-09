package com.lagou.companymgr.job.dao.dao;

import java.util.List;

import com.lagou.companymgr.job.dao.vo.Job;

public interface JobMapper {
   
	public void add(Job j);
	public List<Job>  query0();
	public List<Job>  query1();
	public void del(int id);
	public void updatexiaxian(int id);
	public void updateshangxian(int id);
	public int countjob0();
	public int countjob1();
	public void updatejob(Job j);
	public Job queryjob(int id);
	public List<Job> querybyjob(Job j);
	public Job queryById(int id);
	
	public List<Job> queryAll();
	
	
}
