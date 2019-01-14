package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dsl.BaseJpaRepositoryQueryDsl;
import com.entity.Journal;

public interface JournalRepository extends BaseJpaRepositoryQueryDsl<Journal, String>{

	@Modifying
	@Query(value="select * from journal where user_id = ?1 order by create_time desc" ,nativeQuery=true)
	public List<Journal> getAllJournalByUserId(int userId);

}
