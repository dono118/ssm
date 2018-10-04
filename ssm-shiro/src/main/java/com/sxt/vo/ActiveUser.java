package com.sxt.vo;

import java.util.List;

import com.sxt.domain.User;

public class ActiveUser {

	// 当前用户
	private User currUser;
	// 当前用户的角色
	private List<String> roles;
	// 当前用户的权限
	private List<String> permissions;

	public User getCurrUser() {
		return currUser;
	}

	public void setCurrUser(User currUser) {
		this.currUser = currUser;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

}
