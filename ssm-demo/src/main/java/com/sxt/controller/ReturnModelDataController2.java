package com.sxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.domain.User;
import com.sxt.service.UserService;

/**
 * Controller中如何将model数据返回给页面的demo2
 * @author   Shanks
 * @data     2018年10月4日 下午4:44:49
 * @version  V1.1
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象）,默认是singleton
@RequestMapping("user")
@SessionAttributes({"user"}) //Model中key=user的数据也会存到HttpSession中
public class ReturnModelDataController2 {
	
	@Autowired
	private UserService userService;

	/**
	 * 方式五: 通过@SessionAttributes将指定key的模型数据存到HttpSession中,让页面可以获取
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/view/{id}/use/SessionAttributes", method=RequestMethod.GET)
	public ModelAndView getUserInfo(@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		return new ModelAndView("userinfo", "user", user);
	}
	
}
