package com.lagou.companymgr.companymessage.dao;

import com.lagou.companymgr.companymessage.vo.Companymessage;

public interface CompanymessageMapper 
{
   public void add(Companymessage c);
   
   public Companymessage query(int id);
}
