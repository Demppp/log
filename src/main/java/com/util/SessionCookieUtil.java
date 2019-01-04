package com.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;



import org.springframework.util.StringUtils;





import com.entity.UserInfo;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Component
public class SessionCookieUtil {

	private final static Cache<String, Object> session = CacheBuilder
			.newBuilder()
			// 设置cache的初始大小为10
			.initialCapacity(10)
			// 设置并发数为5
			.concurrencyLevel(5)
			// 设置cache中的数据在写入之后的存活时间为60min
			.expireAfterWrite(60, TimeUnit.MINUTES).build();

	public static void setUser(String username, UserInfo user) {
		SessionCookieUtil.setSession(username, user);
	}

	private static void setSession(String username, UserInfo user) {
		session.put(username, user);
	}

	// 保存cookie七天
	public static void addCookieWeekend(String value) {
		HttpServletResponse response = WebUtils.getResponse();
		Cookie cookie = new Cookie("token", value.trim());
		cookie.setMaxAge(60 * 60 * 24 * 7);// 设置为七天
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	// 保存cookie一天
	public static void addCookieOneDay(String value) {
		HttpServletResponse response = WebUtils.getResponse();
		Cookie cookie = new Cookie("token", value.trim());
		cookie.setMaxAge(60 * 60 * 24);// 设置为一天
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public static void delCookie(String value) {
		HttpServletResponse response = WebUtils.getResponse();
		Cookie cookie = new Cookie("token", value.trim());
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	

	/**
	 * 获取ip地址
	 * 
	 * @return
	 */
	public static String getIpAddr() {
		HttpServletRequest request = WebUtils.getRequest();
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	private static Map<String, Cookie> ReadCookieMap() {
		HttpServletRequest request = WebUtils.getRequest();
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static Cookie getCookieByName(String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap();
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}

	public static UserInfo getUserInfoByToken() {
		String cookie = WebUtils.getRequest().getHeader("cookie");
		if (StringUtils.isEmpty(cookie)) {
			return null;
		}
		String[] split = cookie.split(";")[1].split("=");
		String token = split.length>1?split[1]:"";
		return (UserInfo)WebUtils.getRequest().getSession().getAttribute(token);
		
	}
	
	public static String getToken(){
		String cookie = WebUtils.getRequest().getHeader("cookie");
		if (StringUtils.isEmpty(cookie)) {
			return null;
		}
		String[] split = cookie.split(";")[1].split("=");
		return split.length>1?split[1]:"";
	}
}
