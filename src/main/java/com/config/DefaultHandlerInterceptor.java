package com.config;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.entity.UserInfo;
import com.repository.UserInfoRepository;
import com.util.StringUtil;
import com.util.WebUtils;


public class DefaultHandlerInterceptor implements HandlerInterceptor {
	
	private static final String LOGIN_URL = "/html/index.html";
	
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
		try {
			String cookie = req.getHeader("cookie");
			String[] split = cookie.split("=");
			String token = split.length>1?"":split[1];
			if (!StringUtil.isEmpty(token)) {
				List<UserInfo> list = userInfoRepository.getUserByToken(token);
				if (list.size()==0) {
//					res.getWriter().write("no login");
//					res.sendRedirect(LOGIN_URL);
//					return false;
				}
			}
		} catch (Exception e) {
//			res.getWriter().write("no login");
//			res.sendRedirect(LOGIN_URL);
//			return false;
		}
		WebUtils.setRequest(req);
		WebUtils.setResponse(res);
		return true;
	}
}
