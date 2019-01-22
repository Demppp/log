package com.service;

import com.dto.ResultDTO;
import com.entity.Comment;

public interface CommentService {
	ResultDTO saveComment(Comment c);
}
