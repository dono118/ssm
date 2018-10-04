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

	/**
	 * 根据用户id查询用户信息
	 * @param id
	 * @return User
	 */
	@Override
	public User getUserById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.getAllUsers();
	}

}
