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

import lombok.Data;

@Entity
@Data
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
	
}
