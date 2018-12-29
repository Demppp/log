package com.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.ResultDTO;
import com.dto.ResultEnum;
import com.entity.UserInfo;
import com.repository.UserInfoRepository;
import com.service.UserService;
import com.util.CommonUtil;
import com.util.ResultUtil;
import com.util.SessionCookieUtil;

@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService{

	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Override
	@Transactional
	public UserInfo login(String username, String password) {
		List<UserInfo> list = userInfoRepository.login(username,password);
		if (list.size()>0) {
			UserInfo user = list.get(0);
			String token = CommonUtil.getUUID();
			user.setToken(token);
			user.setStartTime(CommonUtil.getCurrentTime());
			user.setEndTime(CommonUtil.getDayAfterToday(1));
			userInfoRepository.saveAndFlush(user);
			SessionCookieUtil.addCookieOneDay(token);
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	@Transactional
	public ResultDTO addUser(UserInfo user) {
		//检查username是否唯一
		List<UserInfo> list = userInfoRepository.getUserByUsername(user.getUsername());
		if (list.size()>0) {
			return ResultUtil.error(ResultEnum.INFO_DOUBLE);
		}
		userInfoRepository.save(user);
		return ResultUtil.success();
	}

}
