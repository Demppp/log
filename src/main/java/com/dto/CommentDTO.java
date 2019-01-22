package com.dto;

import com.entity.Comment;

public class CommentDTO extends Comment{
	private String username;
	private String userImgPath;
	

	public String getUserImgPath() {
		return userImgPath;
	}

	public void setUserImgPath(String userImgPath) {
		this.userImgPath = userImgPath;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
