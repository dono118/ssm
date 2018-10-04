package com.sxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.domain.User;
import com.sxt.service.UserService;

@Controller
@RequestMapping("user")
public class ReturnJsonDataController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	@ResponseBody
	public User getUserInfo(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value="/view/list")
	@ResponseBody
	public List<User> list() {
		return userService.getAllUsers();
	}
}
