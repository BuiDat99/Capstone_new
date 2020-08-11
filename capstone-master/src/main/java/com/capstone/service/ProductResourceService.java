package com.capstone.service;

import java.util.List;

import com.capstone.entity.ProductResource;
import com.capstone.model.ProductResourceDTO;

public interface ProductResourceService {

	public void addProductResourceWithId(int productId, int resourceId);

	public void addProductResource(ProductResourceDTO productResource);
	
	public void updateProductResource(ProductResourceDTO productResource);
	
	public void deleteProductResource(int id);
	
	public List<ProductResourceDTO> getAllProductResource();
	
	public ProductResourceDTO getProductResourcebyId(int id);
	
	public ProductResourceDTO getProductResourceByProductId(int id);
}
