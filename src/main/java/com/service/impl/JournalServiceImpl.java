package com.service.impl;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dto.ResultDTO;
import com.dto.ResultEnum;
import com.entity.Journal;
import com.entity.Tags;
import com.entity.UserInfo;
import com.repository.JournalRepository;
import com.repository.TagsRepository;
import com.service.JournalService;
import com.util.ResultUtil;
import com.util.SessionCookieUtil;
import com.util.UUIDUtil;

@Service
@Transactional(readOnly=true)
public class JournalServiceImpl implements JournalService{

	@Autowired
	JournalRepository jRepository;
	@Autowired
	TagsRepository tRepository;
	
	
	@Override
	@Transactional
	public ResultDTO saveJounal(Journal j,String tags) {
		try {
			String jid = UUIDUtil.getUUID();
			j.setId(jid);
			j.setCreateTime(new Timestamp(System.currentTimeMillis()));
			j.setAuthor(SessionCookieUtil.getUserInfoByToken().getUsername());
			j.setUserId(SessionCookieUtil.getUserInfoByToken().getId());
			Tags t = new Tags();
			t.setArticleId(jid);
			t.setTagName(tags);
			t.setUserId(SessionCookieUtil.getUserInfoByToken().getId());
			jRepository.save(j);
			tRepository.save(t);
			return ResultUtil.success();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(ResultEnum.UKNOW_ERROR);
		}
		
	}


	@Override
	public List<Journal> getAllJournalByUserId(UserInfo user) {
		return jRepository.getAllJournalByUserId(user.getId());
	}


	@Override
	public Journal getJournalById(String journalId) {
		return jRepository.findById(journalId).get();
	}

}
