package com.lagou.jianli.jobsub.servces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.jobsub.dao.dao.JobsubMapper;
import com.lagou.jianli.jobsub.dao.vo.Jobsub;
@Service
public class JobsubServce 
{
	@Autowired
   private JobsubMapper jdao;
   @Transactional
	public void add(Jobsub j)
   {
	   jdao.add(j);
   }
   
   public List<Jobsub> query(int lid){
	   return jdao.query(lid);
   }
   
   
}
