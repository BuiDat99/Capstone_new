package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ResourceDAO;
import com.capstone.entity.Resource;
import com.capstone.entity.ResourceCategory;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ResourceService;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDAO resourceDao;
	@Override
	public void addResource(ResourceDTO resource) {
		Resource r = new Resource();
		r.setResourceName(resource.getResourceName());
		r.setImage(resource.getImage());
		r.setKcal1g(resource.getKcal1g());
		r.setResourceDescrption(resource.getResourceDescription());
		
		ResourceCategory category = new ResourceCategory();
		category.setId(resource.getCategory().getId());
		category.setCategoryName(resource.getCategory().getCategoryName());
		r.setCategory(category);
		
		resourceDao.addResource(r);
		
	}

	@Override
	public void updateResource(ResourceDTO resourceDTO) {
		Resource r = resourceDao.getResourcebyId(resourceDTO.getId());
		if(r != null) {
			r.setResourceName(resourceDTO.getResourceName());
			r.setImage(resourceDTO.getImage());
			r.setKcal1g(resourceDTO.getKcal1g());
			r.setResourceDescrption(resourceDTO.getResourceDescription());
			
			ResourceCategory category = new ResourceCategory();
			category.setId(resourceDTO.getCategory().getId());
			category.setCategoryName(resourceDTO.getCategory().getCategoryName());
			r.setCategory(category);
			
			resourceDao.updateResource(r);
		}
		
	}

	@Override
	public void deleteResource(int id) {
		Resource r = resourceDao.getResourcebyId(id);
		if(r != null) {
			resourceDao.deleteResource(r);
		}
		
	}

	@Override
	public List<ResourceDTO> getAllResources() {
		List<Resource> rs = resourceDao.getAllResources();
		List<ResourceDTO> dtos = new ArrayList<ResourceDTO>();
		for(Resource r: rs) {
			ResourceDTO dto = new ResourceDTO();
			dto.setId(r.getId());
			dto.setResourceName(r.getResourceName());
			dto.setImage(r.getImage());
			dto.setKcal1g(r.getKcal1g());
			dto.setResourceDescription(r.getResourceDescrption());
			
			ResourceCategoryDTO categoryDTO = new ResourceCategoryDTO();
			categoryDTO.setId(r.getCategory().getId());
			categoryDTO.setCategoryName(r.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public ResourceDTO getResourcebyId(int id) {
		Resource r = resourceDao.getResourcebyId(id);
		ResourceDTO dto = new ResourceDTO();
		dto.setId(r.getId());
		dto.setResourceName(r.getResourceName());
		dto.setImage(r.getImage());
		dto.setKcal1g(r.getKcal1g());
		dto.setResourceDescription(r.getResourceDescrption());
		
		ResourceCategory category = new ResourceCategory();
		category.setId(r.getCategory().getId());
		category.setCategoryName(r.getCategory().getCategoryName());
		r.setCategory(category);
		
		return dto;
	}

	@Override
	public List<ResourceDTO> search(String findName, int start, int length) {
		List<Resource> rs = resourceDao.search(findName, start, length);
		List<ResourceDTO> dtos = new ArrayList<ResourceDTO>();
		for(Resource r: rs) {
			ResourceDTO dto = new ResourceDTO();
			dto.setId(r.getId());
			dto.setResourceName(r.getResourceName());
			dto.setImage(r.getImage());
			dto.setKcal1g(r.getKcal1g());
			dto.setResourceDescription(r.getResourceDescrption());
			
			ResourceCategoryDTO categoryDTO = new ResourceCategoryDTO();
			categoryDTO.setId(r.getCategory().getId());
			categoryDTO.setCategoryName(r.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public int countResourceWhensearch(String name) {		
		return resourceDao.countResourceWhensearch(name);
	}

	@Override
	public List<ResourceDTO> getResourceByCategory(String catName) {
		List<Resource> rs = resourceDao.getResourceByCategory(catName);
		List<ResourceDTO> dtos = new ArrayList<ResourceDTO>();
		for(Resource r: rs) {
			ResourceDTO dto = new ResourceDTO();
			dto.setId(r.getId());
			dto.setResourceName(r.getResourceName());
			dto.setImage(r.getImage());
			dto.setKcal1g(r.getKcal1g());
			dto.setResourceDescription(r.getResourceDescrption());
			
			ResourceCategoryDTO categoryDTO = new ResourceCategoryDTO();
			categoryDTO.setId(r.getCategory().getId());
			categoryDTO.setCategoryName(r.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ResourceDTO> getResourceOfProduct(int productId) {
		List<Resource> rs = resourceDao.getResourceOfProduct(productId);
		List<ResourceDTO> dtos = new ArrayList<ResourceDTO>();
		for(Resource r: rs) {
			ResourceDTO dto = new ResourceDTO();
			dto.setId(r.getId());
			dto.setResourceName(r.getResourceName());
			dto.setImage(r.getImage());
			dto.setKcal1g(r.getKcal1g());
			dto.setResourceDescription(r.getResourceDescrption());
			
			/*
			 * ResourceCategoryDTO categoryDTO = new ResourceCategoryDTO();
			 * categoryDTO.setId(r.getCategory().getId());
			 * categoryDTO.setCategoryName(r.getCategory().getCategoryName());
			 * dto.setCategory(categoryDTO);
			 */
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<ResourceDTO> getResourceFromWithResouceCatId(int id) {
		List<Resource> rs = resourceDao.getResourceFromWithResouceCatId(id);
		List<ResourceDTO> dtos = new ArrayList<ResourceDTO>();
		for(Resource r: rs) {
			ResourceDTO dto = new ResourceDTO();
			dto.setId(r.getId());
			dto.setResourceName(r.getResourceName());
			dto.setImage(r.getImage());
			dto.setKcal1g(r.getKcal1g());
			dto.setResourceDescription(r.getResourceDescrption());
			
			ResourceCategoryDTO categoryDTO = new ResourceCategoryDTO();
			categoryDTO.setId(r.getCategory().getId());
			categoryDTO.setCategoryName(r.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
		}
		return dtos;
	}
}
