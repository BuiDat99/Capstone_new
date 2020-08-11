package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.NewCategoryDAO;
import com.capstone.entity.NewCategory;
import com.capstone.model.NewCategoryDTO;
import com.capstone.service.NewCategoryService;

@Service
@Transactional
public class NewCategoryServiceImpl implements NewCategoryService {

	@Autowired
	private NewCategoryDAO categoryDao;
	
	@Override
	public void addCategory(NewCategoryDTO category) {
		NewCategory nc = new NewCategory();
		nc.setCategoryName(category.getCategoryName());
		categoryDao.addCategory(nc);
		
	}

	@Override
	public void updateCategory(NewCategoryDTO categoryDTO) {
		NewCategory nc = categoryDao.getCategorybyId(categoryDTO.getId());
		if(nc != null) {
			nc.setCategoryName(categoryDTO.getCategoryName());
			categoryDao.updateCategory(nc);
		}
		
	}

	@Override
	public void deleteCategory(int id) {
		NewCategory nc = categoryDao.getCategorybyId(id);
		if(nc != null) {
			categoryDao.deleteCategory(nc);
		}
		
	}

	@Override
	public List<NewCategoryDTO> getAllCategories() {
		List<NewCategory> ncs = categoryDao.getAllCategories();
		List<NewCategoryDTO> dtos = new ArrayList<NewCategoryDTO>();
		for(NewCategory nc: ncs) {
			NewCategoryDTO dto = new NewCategoryDTO();
			dto.setId(nc.getId());
			dto.setCategoryName(nc.getCategoryName());
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public NewCategoryDTO getCategorybyId(int id) {
		NewCategory nc = categoryDao.getCategorybyId(id);
		NewCategoryDTO dto = new NewCategoryDTO();
		dto.setId(nc.getId());
		dto.setCategoryName(nc.getCategoryName());
		return dto;
	}

	@Override
	public List<NewCategoryDTO> search(String findName, int start, int length) {
		List<NewCategory> ncs = categoryDao.search(findName, start, length);
		List<NewCategoryDTO> dtos = new ArrayList<NewCategoryDTO>();
		for(NewCategory nc: ncs) {
			NewCategoryDTO dto = new NewCategoryDTO();
			dto.setId(nc.getId());
			dto.setCategoryName(nc.getCategoryName());
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int countCategoryWhensearch(String name) {
		return categoryDao.countCategoryWhensearch(name);
	}

}
