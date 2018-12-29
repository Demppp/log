package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dsl.BaseJpaRepositoryQueryDsl;
import com.entity.UserInfo;

public interface UserInfoRepository extends BaseJpaRepositoryQueryDsl<UserInfo, String>{

	@Modifying
	@Query(value="select * from user_info where username=?1 and password=?2",nativeQuery=true)
	public List<UserInfo> login(String username, String password) ;

	@Modifying
	@Query(value="select * from user_info where username=?",nativeQuery=true)
	public List<UserInfo> getUserByUsername(String username);

	@Modifying
	@Query(value="select * from user_info where token=?",nativeQuery=true)
	public List<UserInfo> getUserByToken(String token);
	
}
