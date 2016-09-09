package com.lagou.login.user.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lagou.login.user.dao.dao.UserMapper;
import com.lagou.login.user.dao.vo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper udao;
	@Transactional
	public void add(User u) {
            udao.add(u);
	}

	@Transactional
	public void updatePass(User u) {
          udao.updatePass(u);
	}

	@Transactional
	public List<User> queryAll() {
		udao.queryAll();
		return null;
	}

	@Transactional
	public void del(int id) {
        udao.del(id);
	}
	@Transactional
	public User queryByAccount(String account) {
		User user=udao.queryByAccount(account);
		return user;
	}

}
