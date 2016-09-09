package com.lagou.jianli.message.dao.dao;

import com.lagou.jianli.message.dao.vo.Message;

public interface MessageMapper {

	public void add(Message m);
	
	public void update(Message m);
	
	public Message query(int id);
}
