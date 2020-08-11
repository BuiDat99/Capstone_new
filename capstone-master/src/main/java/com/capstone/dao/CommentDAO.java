package com.capstone.dao;

import java.util.List;

import com.capstone.entity.Comment;

public interface CommentDAO {

	public void addComment(Comment comment);
	
	public void updateComment(Comment comment);
	
	public void deleteComment(Comment comment);
	
	public List<Comment> getAllComment();
	
	public List<Comment> getComentbyPostId(int postId, int start, int length);
	
	public int countCommentOfPost(int id);
	
	public Comment getCommentbyId(int id);
}
