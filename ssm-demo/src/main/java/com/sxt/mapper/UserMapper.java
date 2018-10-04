package com.sxt.mapper;

import java.util.List;

import com.sxt.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
	
	/**
	 * 获取所有用户信息
	 */
	List<User> getAllUsers();
}