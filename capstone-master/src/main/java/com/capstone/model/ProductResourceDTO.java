package com.capstone.model;

public class ProductResourceDTO {

	private int id;
	private ResourceDTO resource;
	private ProductDTO product;
	private float gram;
	
	public ProductResourceDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductResourceDTO(int id, ResourceDTO resource, ProductDTO product, float gram) {
		super();
		this.id = id;
		this.resource = resource;
		this.product = product;
		this.gram = gram;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ResourceDTO getResource() {
		return resource;
	}

	public void setResource(ResourceDTO resource) {
		this.resource = resource;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public float getGram() {
		return gram;
	}

	public void setGram(float gram) {
		this.gram = gram;
	}

	
	
	
}
