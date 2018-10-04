package com.sxt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.domain.User;
import com.sxt.service.UserService;

/**
 * Controller中如何将model数据返回给页面的demo1
 * @author   Shanks
 * @data     2018年10月4日 下午12:53:35
 * @version  V1.1
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象）,默认是singleton
@RequestMapping("user")
public class ReturnModelDataController1 {
	
	@Autowired
	private UserService userService;

	/**
	 * 方式一: 通过ModelAndView返回用户信息数据到页面
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/view/{id}/use/ModelAndView", method=RequestMethod.GET)
	public ModelAndView getUserInfo(@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		return new ModelAndView("userinfo", "user", user);
	}
	
	/**
	 * 方式二: 通过Model返回用户信息数据到页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/view/{id}/use/Model", method=RequestMethod.GET)
	public String getUserInfo(@PathVariable("id") Integer id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "userinfo";
	}
	
	/**
	 * 方式三: 通过ModelMap返回用户信息数据到页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/view/{id}/use/ModelMap", method=RequestMethod.GET)
	public String getUserInfo(@PathVariable("id") Integer id, ModelMap model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "userinfo";
	}
	
	/**
	 * 方法四: 通过Map返回用户信息数据到页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/view/{id}/use/Map")
	public String getUserInfo(@PathVariable("id") Integer id, Map<String, Object> map) {
		User user = userService.getUserById(id);
		map.put("user", user);
		return "userinfo";
	}
}
