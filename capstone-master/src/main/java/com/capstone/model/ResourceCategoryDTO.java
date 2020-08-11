package com.capstone.model;

public class ResourceCategoryDTO {

	private int id;
	private String categoryName;
	
	public ResourceCategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public ResourceCategoryDTO(int id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
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
	
	
	
	
}
