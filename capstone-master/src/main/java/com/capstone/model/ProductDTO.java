package com.capstone.model;

import java.util.List;

import lombok.Data;
@Data
public class ProductDTO {

	private int id;
	private String productName;
	private String image;
	private List<String> resources;
	private List<ResourceDTO> resource;
	private List<ProductResourceDTO> productResourceDTOs;
	private String productDescription;
	private String enable;
	public List<ProductResourceDTO> getProductResourceDTOs() {
		return productResourceDTOs;
	}

	public void setProductResourceDTOs(List<ProductResourceDTO> productResourceDTOs) {
		this.productResourceDTOs = productResourceDTOs;
	}

	public List<ResourceDTO> getResource() {
		return resource;
	}

	public void setResource(List<ResourceDTO> resource) {
		this.resource = resource;
	}

	

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

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
