package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.BLogService;


@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	BLogService bService;
	
	@RequestMapping("/toIndex")
	public String toIndex(Model model){
		model.addAttribute("title", "Blog");
		model.addAttribute("BLogDetailsList",bService.getBlogDetailsByUserId().getData());
		return "/home";
	}
	
}
