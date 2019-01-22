package com.controller;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dto.ResultDTO;
import com.entity.Journal;
import com.entity.Tags;
import com.service.JournalService;
import com.service.TagsService;
import com.util.SessionCookieUtil;

@Controller
@RequestMapping("/jounal")
public class JournalController {
	
	@Autowired
	JournalService jservice;
	
	@Autowired
	TagsService tservice;
	
	/**
	 * 保存日志
	 * @param j
	 * @param tags
	 * @return
	 */
	@RequestMapping("/saveJounal")
	@ResponseBody
	public ResultDTO saveJounal(Journal j,String tags){
		return jservice.saveJounal(j,tags);
	}
	
	@RequestMapping("/showJournals")
	public String showJournals(HttpSession session, Model model){
		
		List<Journal> journalList = jservice.getAllJournalByUserId(SessionCookieUtil.getUserInfoByToken());
		List<Tags> tagsList = tservice.getAllTagsByUserInfo(SessionCookieUtil.getUserInfoByToken());
		model.addAttribute("tags", tagsList);
		model.addAttribute("journals",journalList);
		return "/journal";
	}
	
	@RequestMapping("/showJournalDetails/{journalId}")
	public String showJournalDetails(@PathVariable("journalId")String journalId,Model model){
		Journal journal = jservice.getJournalById(journalId);
		model.addAttribute("journal",journal);
		return "/journalDetailInfo";
	}
	
}
