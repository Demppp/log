package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ResultDTO;
import com.entity.Comment;
import com.service.CommentService;

@RequestMapping("/comment")
@RestController
public class CommentController {
	
	@Autowired
	CommentService cService;
	
	@RequestMapping("/saveComment")
	public ResultDTO saveComment(Comment c){
		return cService.saveComment(c);
	}
}
