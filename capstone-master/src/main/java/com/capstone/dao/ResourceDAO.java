package com.capstone.dao;

import java.util.List;

import com.capstone.entity.Resource;

public interface ResourceDAO {
	
	public List<Resource> getResourceOfProduct(int productId);

	public void addResource(Resource resource);
	
	public void updateResource(Resource resource);
	
	public void deleteResource(Resource resource);
	
	public List<Resource> getAllResources();
	
	public List<Resource> getResourceByCategory(String catName);
	
	public Resource getResourcebyId(int id);
	
	public List<Resource> search(String findName, int start, int length);
	
	public int countResourceWhensearch(String name);

	public List<Resource> getResourceFromWithResouceCatId(int id);
}
