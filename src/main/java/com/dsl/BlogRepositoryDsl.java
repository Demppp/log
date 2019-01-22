package com.dsl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dto.CommentDTO;
import com.dto.entity.BlogDTO;
import com.entity.QBlog;
import com.entity.QComment;
import com.entity.QTags;
import com.entity.QUserInfo;
import com.querydsl.core.types.Projections;

@Component
public class BlogRepositoryDsl extends BaseRepositoryDsl {
	QBlog blog = QBlog.blog;
	QTags tags = QTags.tags;
	QComment comment = QComment.comment1;
	QUserInfo user = QUserInfo.userInfo;
	
	public List<BlogDTO> getBLogAndTagName(String blogId) {
		return queryFactory
				.select(
						Projections.bean(
							BlogDTO.class, 
							blog.author,
							blog.cover,
							blog.createTime,
							blog.id,
							blog.text,
							blog.textWithHtml,
							blog.title,
							blog.userId,
							tags.tagName
						)
				)
				.from(blog,tags)
				.where(blog.id.eq(tags.articleId)
						.and(blog.id.eq(blogId)))
				.orderBy(blog.createTime.desc())
				.fetch();
	}
	
	public List<CommentDTO> getBlogCommentByBlogId(String blogId,int userId){
		return queryFactory
				.select(
						Projections.bean(
							CommentDTO.class,
							user.username,
							user.imgPath.as("userImgPath"),
							comment.operateTime,
							comment.comment
						)
				)
				.from(comment,user)
				.where(comment.userId.eq(user.id)
						.and(user.id.eq(userId))
						.and(comment.blogId.eq(blogId)))
				.orderBy(comment.operateTime.desc())
				.fetch();
	}
}
