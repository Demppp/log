package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dsl.BaseJpaRepositoryQueryDsl;
import com.entity.Tags;

public interface TagsRepository extends BaseJpaRepositoryQueryDsl<Tags,String>{

	@Modifying
	@Query(value="select * from tags where user_id = ?1 order by create_time desc" ,nativeQuery=true)
	List<Tags> findTagsByUserInfoOrderByCreateTimeDesc(int id);

	

}
