package com.capstone.dao;

import java.util.List;

import com.capstone.entity.ProductResource;

public interface ProductResourceDAO {

	public void addProductResource(ProductResource productResource);
	
	public void updateProductResourc(ProductResource productResource);
	
	public void deleteProductResourc(ProductResource productResource);
	
	public List<ProductResource> getAllProductResource();
	
	public ProductResource getProductResourcebyId(int id);
	
	public List<ProductResource> getProductResourceByProductId(int id);
}
