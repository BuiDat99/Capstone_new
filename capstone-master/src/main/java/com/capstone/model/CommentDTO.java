package com.capstone.model;

public class CommentDTO {

	private int id;
	private String commentDate;
	private String commentContent;
	private String vote;
	private String react;
	private AppUserDTO user;
	private NewsDTO news;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(int id, String commentDate, String commentContent, String vote, String react, AppUserDTO user,
			NewsDTO news) {
		super();
		this.id = id;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
		this.vote = vote;
		this.react = react;
		this.user = user;
		this.news = news;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	public String getReact() {
		return react;
	}

	public void setReact(String react) {
		this.react = react;
	}

	public AppUserDTO getUser() {
		return user;
	}

	public void setUser(AppUserDTO user) {
		this.user = user;
	}

	public NewsDTO getNews() {
		return news;
	}

	public void setNews(NewsDTO news) {
		this.news = news;
	}
	
	
}
