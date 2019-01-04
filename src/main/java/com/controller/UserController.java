package com.controller;

import javax.servlet.http.HttpServletRequest;
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
	
	/**
	 * 方便开发
	 */
	@RequestMapping("/no_login")
	public ResultDTO no_login(HttpSession session){
		UserInfo userInfo = userService.login("1", "1");
		session.setAttribute(userInfo.getToken(), userInfo);
		return ResultUtil.success();
	}
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
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
	
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@RequestMapping("/regist")
	public ResultDTO regist(UserInfo user){
		System.out.println(user.toString());
		return userService.addUser(user);
	}
	
	/**
	 * 得到用户信息
	 * @param req
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	public ResultDTO getUserInfo(HttpServletRequest req){
		UserInfo userInfo = SessionCookieUtil.getUserInfoByToken();
		if (!StringUtils.isEmpty(userInfo)) {
			return ResultUtil.success(userInfo);
		}else{
			return ResultUtil.error(ResultEnum.UKNOW_ERROR);
		}
	}
	
	/**
	 * 退出
	 * @param req
	 * @return
	 */
	@RequestMapping("/logout")
	public ResultDTO logout(HttpServletRequest req){
		try {
			SessionCookieUtil.delCookie(SessionCookieUtil.getToken());
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.UKNOW_ERROR);
		}
	}
	
	/**
	 * 更新用户信息
	 * @param imgPath
	 * @param username
	 * @return
	 */
	@RequestMapping("/updateUserInfo")
	public ResultDTO updateUserInfo(String imgPath,String username){
		return userService.updateUserInfo(imgPath,username);
	}
	
	/**
	 * 用户名查重
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkUsername")
	public ResultDTO checkUsername(String username){
		return userService.checkUsername(username);
	}
}
