package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Comment")
public class Comment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_Id", nullable = false)
    private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", nullable = false)
    private AppUser appUser;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_Id", nullable = false)
    private News news;
    
    @Column(name = "comment_Date", nullable = false)
    private String comment_Date;
    
    @Column(name = "comment_Content", length = 13000, nullable = false)
    private String comment_Content;
    
    @Column(name = "vote", length = 50, nullable = true)
    private String vote;
    
    @Column(name = "react", length = 50, nullable = true)
    private String react;
    
    @Column(name = "enable", length = 50)
    private String enable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public String getComment_Date() {
		return comment_Date;
	}

	public void setComment_Date(String comment_Date) {
		this.comment_Date = comment_Date;
	}

	public String getComment_Content() {
		return comment_Content;
	}

	public void setComment_Content(String comment_Content) {
		this.comment_Content = comment_Content;
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

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
    
    
	
}
