package com.capstone.service;

import java.util.List;

import com.capstone.model.ProductDTO;

public interface ProductService {

	public void addProduct(ProductDTO product);
	
	public void updateProduct(ProductDTO productDTO);
	
	public void deleteProduct(int id);
	
	public List<ProductDTO> getAllProducts(String enable);
	
	public List<ProductDTO> getTop4Products(String enable);
	
	public List<ProductDTO> getAllProductsByUser(String enable, int id);
	
	public ProductDTO getProductbyId(int id);
	
	public List<ProductDTO> search(String enable,String findName, int start, int length);
	
	public int countProductWhensearch(String enable,String name);
}
