package com.capstone.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NewsDTO {

	private int id;	
	private String title;
	private String imageTitle;
	private String poster;
	private String author;
	private String image;
	private String shortDescription;
	private String detailDescription;
	private String source;
	private String hashtag;
	private String status;
	private String modifiedDate;
	private String creationDate;
	private NewCategoryDTO category;
	private MultipartFile file;
	
	
	public NewsDTO() {
		// TODO Auto-generated constructor stub
	}
	public NewsDTO(int id, String title, String imageTitle, String poster, String author, String image,
			String shortDescription, String detailDescription, String source, String hashtag, String status,
			String modifiedDate, String creationDate, NewCategoryDTO category) {
		super();
		this.id = id;
		this.title = title;
		this.imageTitle = imageTitle;
		this.poster = poster;
		this.author = author;
		this.image = image;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.source = source;
		this.hashtag = hashtag;
		this.status = status;
		this.modifiedDate = modifiedDate;
		this.creationDate = creationDate;
		this.category = category;
	}
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public NewCategoryDTO getCategory() {
		return category;
	}
	public void setCategory(NewCategoryDTO category) {
		this.category = category;
	}
	
	
}
