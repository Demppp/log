package com.service;

import java.util.List;
import java.util.Optional;

import com.dto.ResultDTO;
import com.entity.Journal;
import com.entity.UserInfo;

public interface JournalService {
	public ResultDTO saveJounal(Journal j,String tags);
	public List<Journal> getAllJournalByUserId(UserInfo user);
	public Journal getJournalById(String journalId);
}
