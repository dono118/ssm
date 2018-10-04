package com.sxt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.vo.UserVo;

@Controller
@RequestMapping("login")
public class LoginController {

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}
	
	/**
	 * 登录
	 */
	@RequestMapping("login")
	public String login(UserVo userVo, Model model) {
		// 创建UsernamePasswordToken
		UsernamePasswordToken token = new UsernamePasswordToken(userVo.getUsername(), userVo.getPassword());
		// 得到Subject
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			System.out.println("认证成功!");
			return "list";
		} catch (IncorrectCredentialsException e) {
			System.out.println("密码不正确!");
			model.addAttribute("message", "密码不正确!");
		} catch (UnknownAccountException e) {
			System.out.println("用户不存在!");
			model.addAttribute("message", "用户不存在!");
		}
		
		return "login";
	}
}
