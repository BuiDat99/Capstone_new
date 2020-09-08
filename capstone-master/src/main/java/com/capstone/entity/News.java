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

@Entity
@Table(name = "Posts")
public class News implements Serializable {

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

	@Column(name = "detail_Descripton", length = 30000, nullable = false)
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
	@JoinColumn(name = "category_Id")
	private NewCategory category;

	@ManyToOne
	@JoinColumn(name = "user_Id")
	private AppUser appUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public NewCategory getCategory() {
		return category;
	}

	public void setCategory(NewCategory category) {
		this.category = category;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

}
