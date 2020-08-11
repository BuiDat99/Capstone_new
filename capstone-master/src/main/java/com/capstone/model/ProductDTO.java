package com.capstone.model;

import java.util.List;

public class ProductDTO {

	private int id;
	private String productName;
	private String image;
	private List<String> resources;

	public List<String> getResources() {
		return this.resources;
	}

	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(int id, String productName, String image) {
		super();
		this.id = id;
		this.productName = productName;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
