package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dto.CommentDTO;
import com.dto.ResultDTO;
import com.dto.entity.BlogDTO;
import com.entity.Blog;
import com.service.BLogService;


@RequestMapping("/blog")
@Controller
public class BlogController {
	@Autowired
	BLogService bService;
	
	@RequestMapping("/saveBLog")
	@ResponseBody
	public ResultDTO saveBLog(Blog blog,String tags){
		return bService.saveBLog(blog,tags);
	}
	
	@RequestMapping("/showBlogDetails/{blogId}")
	public String showBlogDetails(@PathVariable("blogId")String blogId,Model model){
		BlogDTO blogDTO = bService.getBLogDetails(blogId);
		List<CommentDTO> commentDTOList = bService.getCommentByBlogId(blogId);
		model.addAttribute("blogDTO", blogDTO);
		model.addAttribute("commentDTOList",commentDTOList);
		return "/blogDetailsInfo";
	}
}
