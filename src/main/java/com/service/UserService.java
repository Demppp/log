package com.service;

import com.dto.ResultDTO;
import com.entity.UserInfo;

public interface UserService {
	ResultDTO login(String username,String password);

	ResultDTO addUser(UserInfo user);
}
