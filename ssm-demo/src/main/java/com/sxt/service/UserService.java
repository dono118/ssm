package com.sxt.service;

import java.util.List;

import com.sxt.domain.User;

public interface UserService {
	
	/**
	 * 根据用户id查询用户信息
	 */
	User getUserById(Integer id);
	
	/**
	 * 获取所有用户信息
	 */
	List<User> getAllUsers();
}
