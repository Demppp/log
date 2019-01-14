package com.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article",schema="public",catalog="log")
public class Article {
	private String id;
	private String title;
	private String type;
	private String text;
	private String textWithHtml;
	private Timestamp createTime;
	private String userId;
	private String author;
	private String cover;
	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Basic
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Basic
	@Column(name="type")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Basic
	@Column(name="text")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Basic
	@Column(name="text_with_html")
	public String getTextWithHtml() {
		return textWithHtml;
	}
	public void setTextWithHtml(String textWithHtml) {
		this.textWithHtml = textWithHtml;
	}
	@Basic
	@Column(name="create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	@Basic
	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Basic
	@Column(name="author")
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Basic
	@Column(name="cover")
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
}
