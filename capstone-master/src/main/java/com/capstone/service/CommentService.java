package com.capstone.service;

import java.util.List;

import com.capstone.model.CommentDTO;

public interface CommentService {

	public void addComment(CommentDTO comment, int postId);
	
	public void updateComment(CommentDTO comment);
	
	public void deleteComment(int id);
	
	public List<CommentDTO> getAllComment();
	
	public CommentDTO getCommentbyId(int id);
	
	public List<CommentDTO> getComentbyPostId(String enable,int postId, int start, int length);
	
	public int countCommentOfPost(int id);
}
