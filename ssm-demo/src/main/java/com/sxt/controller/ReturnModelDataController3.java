package com.sxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sxt.domain.User;
import com.sxt.service.UserService;

/**
 * Controller中如何将model数据返回给页面的demo3
 * @author   Shanks
 * @data     2018年10月4日 下午4:53:40
 * @version  V1.1
 */
@Controller
@Scope(value="singleton") //只实例化一个bean对象（即每次请求都使用同一个bean对象）,默认是singleton
@RequestMapping("user")
public class ReturnModelDataController3 {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 指定@ModelAttribute的name或value都是一样的功能,都是作为key,将注解的方法返回的对象作为value存放到Model中
	 * @param id
	 * @return
	 */
	@ModelAttribute(name="user")
	public User getUserinfo(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}

	// 上面的方法等价于
	/*@ModelAttribute	
	public void addAccount(@PathVariable("id") Integer id, Model model) {
		User user =  userService.getUserById(id);
		model.addAttribute("user", user);
	}*/

	/**
	 * 方式六: 通过@ModelAttribute将指定key的模型数据存到HttpServletRequest中,让页面可以获取
	 * 使用@ModelAttribute注解的方法会在此Controller每个方法执行前被执行
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value="/view/{id}/use/ModelAttribute", method=RequestMethod.GET)
	public String getUserInfo() {
		return "userinfo";
	}
	
}
