package com.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsl.BlogRepositoryDsl;
import com.dto.CommentDTO;
import com.dto.ResultDTO;
import com.dto.ResultEnum;
import com.dto.entity.BlogDTO;
import com.entity.Blog;
import com.entity.Tags;
import com.repository.BlogRepository;
import com.repository.TagsRepository;
import com.service.BLogService;
import com.util.ResultUtil;
import com.util.SessionCookieUtil;
import com.util.UUIDUtil;

@Service
@Transactional(readOnly=true)
public class BlogServiceImpl implements BLogService{

	@Autowired
	BlogRepository bRepository;
	
	@Autowired
	TagsRepository tRepository;
	
	@Autowired
	BlogRepositoryDsl bRepositoryDsl;
	
	@Override
	@Transactional
	public ResultDTO saveBLog(Blog blog,String tags) {
		try {
			String bId = UUIDUtil.getUUID();
			blog.setId(bId);
			blog.setAuthor(SessionCookieUtil.getUserInfoByToken().getUsername());
			blog.setCreateTime(new Timestamp(System.currentTimeMillis()));
			blog.setUserId(SessionCookieUtil.getUserInfoByToken().getId());
			bRepository.save(blog);
			Tags tag = new Tags();
			tag.setArticleId(bId);
			tag.setArticletType(2);
			tag.setCreateTime(new Timestamp(System.currentTimeMillis()));
			tag.setTagName(tags);
			tag.setUserId(SessionCookieUtil.getUserInfoByToken().getId());
			tRepository.save(tag);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.UKNOW_ERROR);
		}
	}

	@Override
	@Transactional
	public BlogDTO getBLogDetails(String blogId) {
		List<BlogDTO> list = bRepositoryDsl.getBLogAndTagName(blogId);
		return list.size()>0?list.get(0):null;
	}

	@Override
	public ResultDTO getBlogDetailsByUserId() {
		try {
			List<Blog> list = bRepository.getBlogDetailsByUserId(SessionCookieUtil
					.getUserInfoByToken().getId());
			return ResultUtil.success(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.UKNOW_ERROR);
		}
	}

	@Override
	public List<CommentDTO> getCommentByBlogId(String blogId) {
		try {
			List<CommentDTO> data = bRepositoryDsl.getBlogCommentByBlogId(blogId, SessionCookieUtil.getUserInfoByToken().getId());
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
