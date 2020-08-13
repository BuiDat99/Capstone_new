package com.capstone.dao;

import java.util.List;

import com.capstone.entity.ResourceCategory;

public interface ResourceCategoryDAO {

	public void addCategory(ResourceCategory category);
	
	public void updateCategory(ResourceCategory category);
	
	public void deleteCategory(ResourceCategory category);
	
	public List<ResourceCategory> getAllCategories(String b);
	
	public ResourceCategory getCategorybyId(int id);
	
	public List<ResourceCategory> search(String b,String findName, int start, int length);
	
	public int countCategoryWhensearch(String b,String name);
}
