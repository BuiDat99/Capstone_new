package com.capstone.model;

public class ResourceCategoryDTO {

	private int id;
	private String categoryName;
	private String enable;
	public ResourceCategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	public ResourceCategoryDTO(int id, String categoryName, String enable) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.enable = enable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}

	
	
	
	
	
}
