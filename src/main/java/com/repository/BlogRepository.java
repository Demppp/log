package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dsl.BaseJpaRepositoryQueryDsl;
import com.entity.Blog;

public interface BlogRepository extends BaseJpaRepositoryQueryDsl<Blog,String>{

	@Modifying
	@Query(value="select * from blog where user_id = ?1",nativeQuery=true)
	public List<Blog> getBlogDetailsByUserId(int userId);
}
