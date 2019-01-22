package com.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dto.ResultDTO;
import com.dto.ResultEnum;
import com.entity.Comment;
import com.repository.CommentRepository;
import com.service.CommentService;
import com.util.ResultUtil;
import com.util.SessionCookieUtil;
import com.util.UUIDUtil;

@Service
@Transactional(readOnly=true)
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository cRepository;
	
	@Transactional
	public ResultDTO saveComment(Comment c) {
		try {
			c.setUserId(SessionCookieUtil.getUserInfoByToken().getId());
			c.setId(UUIDUtil.getUUID());
			c.setOperateTime(new Timestamp(System.currentTimeMillis()));
			cRepository.save(c);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.UKNOW_ERROR);
		}
	}

}
