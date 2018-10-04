package com.sxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.domain.User;
import com.sxt.mapper.UserMapper;
import com.sxt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User queryUserByUsername(String username) {
		return userMapper.queryUserByUsername(username);
	}

	@Override
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

}
