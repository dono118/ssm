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
	 * 根据userName查询用户
	 */
	User queryUserByUsername(String username);
	/**
	 * 查询所有用户
	 */
	List<User> selectAll();
}