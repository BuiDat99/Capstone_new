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
@Table(name="Resources")
public class Resource implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resource_Id", nullable = false)
	private int id;
	
	@Column(name = "image", length = 50)
	private String image;
	
	@Column(name = "resource_Name", length = 50, nullable = false)
	private String resourceName;
	
	@Column(name = "resource_Description", length = 1000, nullable = false)
	private String resourceDescrption;
	
	@Column(name = "kcal1g", nullable = false)
	private float kcal1g ;	

	@ManyToOne
	@JoinColumn(name="category_Id")
	private ResourceCategory category;
	
	@Column(name = "enable", length = 50)
    private String enable;

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

	public String getResourceDescrption() {
		return resourceDescrption;
	}

	public void setResourceDescrption(String resourceDescrption) {
		this.resourceDescrption = resourceDescrption;
	}

	public float getKcal1g() {
		return kcal1g;
	}

	public void setKcal1g(float kcal1g) {
		this.kcal1g = kcal1g;
	}

	public ResourceCategory getCategory() {
		return category;
	}

	public void setCategory(ResourceCategory category) {
		this.category = category;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	
}
