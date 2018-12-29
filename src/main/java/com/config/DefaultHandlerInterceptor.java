package com.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.entity.UserInfo;
import com.repository.UserInfoRepository;
import com.util.WebUtils;


public class DefaultHandlerInterceptor implements HandlerInterceptor {
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		String cookie = req.getHeader("cookie");
		String[] split = cookie.split("=");
		String token = split.length>1?"":split[1];
		List<UserInfo> list = userInfoRepository.getUserByToken(token);
		if (list.size()<0) {
			
		}
		WebUtils.setRequest(req);
		WebUtils.setResponse(res);
		return true;
	}
}
