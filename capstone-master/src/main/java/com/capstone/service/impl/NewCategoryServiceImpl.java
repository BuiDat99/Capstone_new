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
		nc.setEnable("1");
		categoryDao.addCategory(nc);
		
	}

	@Override
	public void updateCategory(NewCategoryDTO categoryDTO) {
		NewCategory nc = categoryDao.getCategorybyId(categoryDTO.getId());
		if(nc != null) {
			nc.setCategoryName(categoryDTO.getCategoryName());
			nc.setEnable(categoryDTO.getEnable());
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
	public List<NewCategoryDTO> getAllCategories(String a) {
		List<NewCategory> ncs = categoryDao.getAllCategories(a);
		List<NewCategoryDTO> dtos = new ArrayList<NewCategoryDTO>();
		for(NewCategory nc: ncs) {
			NewCategoryDTO dto = new NewCategoryDTO();
			dto.setId(nc.getId());
			dto.setCategoryName(nc.getCategoryName());
			dto.setEnable(nc.getEnable());
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
		dto.setEnable(nc.getEnable());
		return dto;
	}

	@Override
	public List<NewCategoryDTO> search(String a,String findName, int start, int length) {
		List<NewCategory> ncs = categoryDao.search(a,findName, start, length);
		List<NewCategoryDTO> dtos = new ArrayList<NewCategoryDTO>();
		for(NewCategory nc: ncs) {
			NewCategoryDTO dto = new NewCategoryDTO();
			dto.setId(nc.getId());
			dto.setCategoryName(nc.getCategoryName());
			dto.setEnable(nc.getEnable());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int countCategoryWhensearch(String a,String name) {
		return categoryDao.countCategoryWhensearch(a,name);
	}

}
