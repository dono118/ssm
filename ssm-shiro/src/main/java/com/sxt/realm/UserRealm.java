package com.sxt.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.sxt.domain.User;
import com.sxt.service.PermissionService;
import com.sxt.service.UserService;
import com.sxt.vo.ActiveUser;

public class UserRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户名
		String username = token.getPrincipal().toString();
		// 根据用户名去数据库查询
		User user = userService.queryUserByUsername(username);
		ActiveUser activeUser = new ActiveUser();
		if (null != user) {
			activeUser.setCurrUser(user);
			// 根据用户id查询角色
//			activeUser.setRoles(roleService.selectByUserId(user.getId()));
			// 根据用户id查询权限
			activeUser.setPermissions(permissionService.selectByUserId(user.getId()));
			
			ByteSource salt = ByteSource.Util.bytes(user.getUsername() + user.getAddress());
			AuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, user.getPassword(), salt, this.getName());
			return info;
		}else {
			// 说明用户名不存在
			return null;
		}
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取ActiveUser
		ActiveUser activeUser = (ActiveUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (activeUser.getRoles() != null && activeUser.getRoles().size() > 0) {
			info.addRoles(activeUser.getRoles());
		}
		if (activeUser.getPermissions() != null && activeUser.getPermissions().size() > 0) {
			info.addStringPermissions(activeUser.getPermissions());
		}
		return info;
	}

}
