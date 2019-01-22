package com.service;

import java.util.List;

import com.dto.CommentDTO;
import com.dto.ResultDTO;
import com.dto.entity.BlogDTO;
import com.entity.Blog;

public interface BLogService {
	ResultDTO saveBLog(Blog blog,String tags);

	BlogDTO getBLogDetails(String blogId);

	ResultDTO getBlogDetailsByUserId();

	List<CommentDTO> getCommentByBlogId(String blogId);
}
