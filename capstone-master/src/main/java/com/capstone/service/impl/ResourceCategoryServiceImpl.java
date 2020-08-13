package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ResourceCategoryDAO;
import com.capstone.entity.ResourceCategory;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.service.ResourceCategoryService;

@Service
@Transactional
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

	@Autowired
	private ResourceCategoryDAO categoryDao;
	@Override
	public void addCategory(ResourceCategoryDTO category) {
		ResourceCategory rc = new ResourceCategory();
		rc.setCategoryName(category.getCategoryName());
		rc.setEnable("1");
		categoryDao.addCategory(rc);
		
	}

	@Override
	public void updateCategory(ResourceCategoryDTO categoryDTO) {
		ResourceCategory rc = categoryDao.getCategorybyId(categoryDTO.getId());
		if(rc != null) {
			rc.setCategoryName(categoryDTO.getCategoryName());
			rc.setEnable(categoryDTO.getEnable());
			categoryDao.updateCategory(rc);
		}
		
	}

	@Override
	public void deleteCategory(int id) {
		ResourceCategory rc = categoryDao.getCategorybyId(id);
		if(rc != null) {
			categoryDao.deleteCategory(rc);
		}
		
	}

	@Override
	public List<ResourceCategoryDTO> getAllCategories(String a) {
		List<ResourceCategory> rcs = categoryDao.getAllCategories(a);
		List<ResourceCategoryDTO> dtos = new ArrayList<ResourceCategoryDTO>();
		for(ResourceCategory rc: rcs) {
			ResourceCategoryDTO dto = new ResourceCategoryDTO();
			dto.setId(rc.getId());
			dto.setCategoryName(rc.getCategoryName());
			dto.setEnable(rc.getEnable());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public ResourceCategoryDTO getCategorybyId(int id) {
		ResourceCategory rc = categoryDao.getCategorybyId(id);
		ResourceCategoryDTO dto = new ResourceCategoryDTO();
		dto.setId(rc.getId());
		dto.setCategoryName(rc.getCategoryName());
		dto.setEnable(rc.getEnable());
		return dto;
	}

	@Override
	public List<ResourceCategoryDTO> search(String a,String findName, int start, int length) {
		List<ResourceCategory> rcs = categoryDao.search(a,findName, start, length);
		List<ResourceCategoryDTO> dtos = new ArrayList<ResourceCategoryDTO>();
		for(ResourceCategory rc: rcs) {
			ResourceCategoryDTO dto = new ResourceCategoryDTO();
			dto.setId(rc.getId());
			dto.setCategoryName(rc.getCategoryName());
			dto.setEnable(rc.getEnable());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int countCategoryWhensearch(String a ,String name) {
		return categoryDao.countCategoryWhensearch(a, name);
	}

}
