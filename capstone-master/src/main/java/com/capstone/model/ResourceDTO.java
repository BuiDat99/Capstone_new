package com.capstone.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ResourceDTO {

	private int id;
	private String image;
	private String resourceName;
	private String resourceDescription;
	private float kcal1g;
	private ResourceCategoryDTO category;
	private String enable;
	private MultipartFile file;
	public ResourceDTO() {
		// TODO Auto-generated constructor stub
	}

	public ResourceDTO(int id, String image, String resourceName, String resourceDescription, float kcal1g,
			ResourceCategoryDTO category) {
		super();
		this.id = id;
		this.image = image;
		this.resourceName = resourceName;
		this.resourceDescription = resourceDescription;
		this.kcal1g = kcal1g;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceDescription() {
		return resourceDescription;
	}

	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}

	public float getKcal1g() {
		return kcal1g;
	}

	public void setKcal1g(float kcal1g) {
		this.kcal1g = kcal1g;
	}

	public ResourceCategoryDTO getCategory() {
		return category;
	}

	public void setCategory(ResourceCategoryDTO category) {
		this.category = category;
	}
	
	
	
}
