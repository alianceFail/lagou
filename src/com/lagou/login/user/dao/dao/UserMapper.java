package com.lagou.login.user.dao.dao;

import java.util.List;

import com.lagou.login.user.dao.vo.User;

public interface UserMapper {

	   public void add(User u);
	   public void updatePass(User u);
	   public List<User>queryAll();
	   public void del(int id);
	   public User queryByAccount(String account);
}