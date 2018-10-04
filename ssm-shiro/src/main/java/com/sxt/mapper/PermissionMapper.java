package com.sxt.mapper;

import java.util.List;

import com.sxt.domain.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    /**
     * 根据用户id查询权限
     */
    List<Permission> selectByUserId(Integer uid);
}