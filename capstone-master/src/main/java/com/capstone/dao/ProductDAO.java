package com.capstone.dao;

import java.util.List;

import com.capstone.entity.Product;

public interface ProductDAO {

	public List<String> getProductNameContainResource(int resourceId );

	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public List<Product> getAllProduct(String enable);
	
	public List<Product> getTop4Products(String enable);
	
	public List<Product> getAllProductByUser(String enable, int id);
	
	public Product getProductbyId(int id);
	
	public List<Product> search(String enable, String findName, int start, int length);
	
	public int countProductWhensearch(String enable,String name);
}
