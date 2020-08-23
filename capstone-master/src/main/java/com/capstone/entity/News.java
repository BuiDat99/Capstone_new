package com.capstone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Posts")
public class News implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_Id", nullable = false)
	private int id;
	
	@Column(name = "title", length = 255, nullable = false)
	private String title;
	
	@Column(name = "image_Title", length = 50)
	private String imageTitle;
	
	@Column(name = "poster", length = 255, nullable = false)
	private String poster;
	
	@Column(name = "author", length = 255, nullable = false)
	private String author;
	
	
	@Column(name = "short_Description", length = 1000, nullable = false)
	private String shortDescription;
	
	@Column(name = "detail_Descripton", length = 13000, nullable = false)
	private String detailDescription;
	
	@Column(name = "source", length = 255, nullable = false)
	private String source;
	
	@Column(name = "hashtag", length = 50, nullable = false)
	private String hashtag;
	
	@Column(name = "status", length = 50, nullable = false)
	private String status;
	
	@Column(name = "modified_Date", nullable = false)
	private String modifiedDate;
	
	@Column(name = "creation_Date", nullable = false)
	private String creationDate;
	
	@ManyToOne
	@JoinColumn(name="category_Id")
	private NewCategory category;
	
	@ManyToOne
	@JoinColumn(name="user_Id")
	private AppUser appUser;
	
}
