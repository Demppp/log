package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Tags;
import com.entity.UserInfo;
import com.repository.TagsRepository;
import com.service.TagsService;

@Service
@Transactional
public class TagsServiceImpl implements TagsService{

	@Autowired
	TagsRepository tRepository;
	
	
	@Override
	public List<Tags> getAllTagsByUserInfo(UserInfo user) {
		return tRepository.findTagsByUserInfoOrderByCreateTimeDesc(user.getId());
	}

}
