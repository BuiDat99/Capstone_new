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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Float getKcal1g() {
		return kcal1g;
	}

	public void setKcal1g(Float kcal1g) {
		this.kcal1g = kcal1g;
	}
	
	
}
