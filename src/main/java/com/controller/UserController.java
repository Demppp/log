package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ResultDTO;
import com.entity.UserInfo;
import com.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public ResultDTO login(String username,String password){
		System.out.println(username + ":" + password);
		return userService.login(username, password);
	}
	
	@RequestMapping("/regist")
	public ResultDTO regist(UserInfo user){
		System.out.println(user.toString());
		return userService.addUser(user);
	}
}
