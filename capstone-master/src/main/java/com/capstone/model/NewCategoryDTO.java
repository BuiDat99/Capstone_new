package com.capstone.model;

public class NewCategoryDTO {

	private int id;
	private String categoryName;
	private String count;
	
	public NewCategoryDTO() {
		// TODO Auto-generated constructor stub
	}

	public NewCategoryDTO(int id, String categoryName) {
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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	
}
