package com.dto.entity;

import com.entity.Blog;

public class BlogDTO extends Blog{
	private String tagName;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
}
