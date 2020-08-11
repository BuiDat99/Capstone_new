package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ProductResourceDAO;
import com.capstone.dao.impl.ProductDAOImpl;
import com.capstone.dao.impl.ResourceDAOImpl;
import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ProductResourceService;

@Service
@Transactional
public class ProductResourceServiceImpl implements ProductResourceService {

	@Autowired
	private ProductResourceDAO productResourceDAO;

	@Autowired
	private ProductDAOImpl productDAOImpl;

	@Autowired
	private ResourceDAOImpl resourceDAOImpl;

	@Override
	public void addProductResourceWithId(int productId, int resourceId) {
		Product p = productDAOImpl.getProductbyId(productId);
		Resource r = resourceDAOImpl.getResourcebyId(resourceId);

		ProductResource pr = new ProductResource();
		pr.setProduct(p);
		pr.setResource(r);
		
		productResourceDAO.addProductResource(pr);
	}

	@Override
	public void addProductResource(ProductResourceDTO ProductResourceDTO) {
		ProductResource pr = new ProductResource();
		Product p = new Product();
		Resource r = new Resource();
		
		pr.setProduct(p);
		pr.setResource(r);
		
		productResourceDAO.addProductResource(pr);
		
	}

	@Override
	public void updateProductResource(ProductResourceDTO productResource) {
		ProductResource pr = productResourceDAO.getProductResourcebyId(productResource.getId());
		if(pr != null) {
			Product p = new Product();
			Resource r = new Resource();
			pr.setProduct(p);
			pr.setResource(r);
			
			productResourceDAO.updateProductResourc(pr);
		}
		
	}

	@Override
	public void deleteProductResource(int id) {
		ProductResource pr = productResourceDAO.getProductResourceByProductId(id);
		
		if(pr != null) {
			productResourceDAO.deleteProductResourc(pr);
		}
		
	}

	@Override
	public List<ProductResourceDTO> getAllProductResource() {
		List<ProductResource> prs = productResourceDAO.getAllProductResource();
		List<ProductResourceDTO> dtos = new ArrayList<ProductResourceDTO>();
		for(ProductResource pr: prs) {
			ProductResourceDTO dto = new ProductResourceDTO();
			dto.setId(pr.getId());
			
			ProductDTO pdto = new ProductDTO();
			pdto.setId(pr.getProduct().getId());
			pdto.setProductName(pr.getProduct().getProductName());
			pdto.setImage(pr.getProduct().getImage());
			dto.setProduct(pdto);
			
			ResourceDTO rdto = new ResourceDTO();
			rdto.setId(pr.getResource().getId());
			rdto.setResourceName(pr.getResource().getResourceName());		
			dto.setResource(rdto);
			
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public ProductResourceDTO getProductResourcebyId(int id) {
		ProductResource pr = productResourceDAO.getProductResourcebyId(id);
		ProductResourceDTO dto = new ProductResourceDTO();
		ProductDTO pdto = new ProductDTO();
		ResourceDTO rdto = new ResourceDTO();
		dto.setId(pr.getId());
		dto.setProduct(pdto);
		dto.setResource(rdto);
		return dto;
	}

	@Override
	public ProductResourceDTO getProductResourceByProductId(int id) {
		
		return null;
		
	}

}
