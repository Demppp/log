package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ResultDTO;
import com.dto.ResultEnum;
import com.entity.UserInfo;
import com.service.UserService;
import com.util.ResultUtil;
import com.util.SessionCookieUtil;

@RequestMapping("/user")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
	public ResultDTO login(String username,String password,HttpSession session){
		System.out.println(username + ":" + password);
		UserInfo userInfo = userService.login(username, password);
		if (!StringUtils.isEmpty(userInfo)) {
			session.setAttribute(userInfo.getToken(), userInfo);
			return ResultUtil.success(userInfo);
		}else{
			return ResultUtil.error(ResultEnum.USERINFO_ERROR);
		}
	}
	
	@RequestMapping("/regist")
	public ResultDTO regist(UserInfo user){
		System.out.println(user.toString());
		return userService.addUser(user);
	}
	
	@RequestMapping("/getUserInfo")
	public ResultDTO getUserInfo(){
		if (StringUtils.isEmpty(SessionCookieUtil.getUser())) {
			return ResultUtil.success(SessionCookieUtil.getUser());
		}else{
			return ResultUtil.error(ResultEnum.UKNOW_ERROR);
		}
		
	}
}
