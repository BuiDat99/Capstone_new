package com.capstone.entity;

import java.io.Serializable;
import java.util.ArrayList;
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

import lombok.Data;

@Entity
@Data
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
}
