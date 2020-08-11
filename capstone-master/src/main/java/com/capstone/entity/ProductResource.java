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

import lombok.Data;

@Entity
@Data
@Table(name="Product_Resource")
public class ProductResource implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pr_Id", nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="resource_Id")
	private Resource resource;
	
	@ManyToOne
	@JoinColumn(name="product_Id")
	private Product product;
	
	private Float kcal1g;
}
