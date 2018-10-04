package com.sxt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxt.domain.User;
import com.sxt.service.UserService;

/**
 * Controller中如何将model数据返回给页面的demo4
 * @author   Shanks
 * @data     2018年10月4日 下午6:35:10
 * @version  V1.1
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象）,默认是singleton
@RequestMapping("user")
public class ReturnModelDataController4 {
	
	@Autowired
	private UserService userService;

	/**
	 * 方式七: 直接将数据存到HttpSession中,让页面可以获取
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/view/{id}/use/HttpSession", method=RequestMethod.GET)
	public String getUserInfo(@PathVariable("id") Integer id, HttpSession session) {
		User user = userService.getUserById(id);
		session.setAttribute("user", user);
		return "userinfo";
	}
	
	/**
	 * 方式八: 直接将数据存到HttpServletRequest中,让页面可以获取
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/view/{id}/use/HttpServletRequest", method=RequestMethod.GET)
	public String getUserInfo(@PathVariable("id") Integer id, HttpServletRequest request) {
		User user = userService.getUserById(id);
		request.setAttribute("user", user);
		return "userinfo";
	}
}
