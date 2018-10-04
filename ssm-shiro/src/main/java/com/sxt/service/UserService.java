package com.sxt.service;

import java.util.List;

import com.sxt.domain.User;

public interface UserService {

	/**
	 * 根据userName查询用户
	 */
	User queryUserByUsername(String username);
	/**
	 * 查询所有用户
	 */
	List<User> selectAll();
}
