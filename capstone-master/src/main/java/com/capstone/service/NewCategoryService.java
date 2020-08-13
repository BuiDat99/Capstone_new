package com.capstone.service;

import java.util.List;

import com.capstone.model.NewCategoryDTO;

public interface NewCategoryService {

	public void addCategory(NewCategoryDTO category);
	
	public void updateCategory(NewCategoryDTO categoryDTO);
	
	public void deleteCategory(int id);
	
	public List<NewCategoryDTO> getAllCategories(String e);
	
	public NewCategoryDTO getCategorybyId(int id);
	
	public List<NewCategoryDTO> search(String e,String findName, int start, int length);
	
	public int countCategoryWhensearch(String a,String name);
}
