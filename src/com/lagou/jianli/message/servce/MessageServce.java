package com.lagou.jianli.message.servce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.jianli.message.dao.dao.MessageMapper;
import com.lagou.jianli.message.dao.vo.Message;
@Service
public class MessageServce 
{ 
	@Autowired
	private MessageMapper mm;
	@Transactional	
  public void add(Message m)
  {
	  mm.add(m);
  }
	@Transactional
	public void update(Message m){
		mm.update(m);
	}
	
	public Message query(int id){
		return mm.query(id);
	}
}
