package com.lagou.jianli.jobsub.dao.dao;

import java.util.List;

import com.lagou.jianli.jobsub.dao.vo.Jobsub;

public interface JobsubMapper 
{
   public void add(Jobsub j);
   
   public List<Jobsub> query(int lid);
   
}
