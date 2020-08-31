package com.capstone.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_Id", nullable = false)
	private int id;
	
	@Column(name = "product_Name", length = 255, nullable = false)
	private String productName;
	
	@Column(name = "image", length = 50)
	private String image;
	
	@Column(name = "product_Description", length = 500, nullable = false)
	private String productDescription;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.LAZY)
	List<ProductResource> productResources;
	
	@Column(name = "enable", length = 50)
    private String enable;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_Id")
	private AppUser user;

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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public List<ProductResource> getProductResources() {
		return productResources;
	}

	public void setProductResources(List<ProductResource> productResources) {
		this.productResources = productResources;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}
	
	
}
