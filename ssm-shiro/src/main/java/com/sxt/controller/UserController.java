package com.sxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.domain.User;
import com.sxt.service.UserService;


@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("loadAllUsers")
	@ResponseBody
	public List<User> loadAllUsers() {
		 return userService.selectAll();
	}
}
