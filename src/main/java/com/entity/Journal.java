package com.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="journal",schema="public",catalog="log")
public class Journal {
	private String id;
	private String author;
	private String text;
	private String textWithHtml;
	private Timestamp createTime;
	private String title;
	private int userId;
	
	
	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Column(name="text", columnDefinition="TEXT")
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	@Basic
	@Column(name="text_with_html", columnDefinition="TEXT")
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
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Basic
	@Column(name="user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
