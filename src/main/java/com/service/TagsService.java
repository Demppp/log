package com.service;

import java.util.List;

import com.entity.Tags;
import com.entity.UserInfo;

public interface TagsService {

	List<Tags> getAllTagsByUserInfo(UserInfo userInfoByToken);

}
