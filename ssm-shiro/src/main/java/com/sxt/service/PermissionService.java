package com.sxt.service;

import java.util.List;

public interface PermissionService {
	
    /**
     * 根据用户id查询权限code集合
     */
    List<String> selectByUserId(Integer uid);
}