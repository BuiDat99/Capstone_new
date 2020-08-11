package com.capstone.service;

import java.util.List;
import com.capstone.model.ResourceCategoryDTO;

public interface ResourceCategoryService {

	public void addCategory(ResourceCategoryDTO category);
	
	public void updateCategory(ResourceCategoryDTO categoryDTO);
	
	public void deleteCategory(int id);
	
	public List<ResourceCategoryDTO> getAllCategories();
	
	public ResourceCategoryDTO getCategorybyId(int id);
	
	public List<ResourceCategoryDTO> search(String findName, int start, int length);
	
	public int countCategoryWhensearch(String name);
}
