package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ProductDAO;
import com.capstone.dao.ProductResourceDAO;
import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ProductService;

@Service
@Transactional
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private ProductResourceDAO productResourceDAO;
	
	@Override
	public void addProduct(ProductDTO productDTO) {
		Product p = new Product();
		p.setImage(productDTO.getImage());
		p.setProductName(productDTO.getProductName());
		productDao.addProduct(p);		
		//tao moi 1 product
		productDTO.setId(p.getId());
		// lay duoc id cua product
		
		ResourceDTO resource = new ResourceDTO();
		Resource r = new Resource();
		resource.setId(r.getId());		
		// lay duoc id cua resource
		
		ProductResource productResource = new ProductResource();
		
		
		
		
		
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		Product p =new Product();
		if(productDTO.getImage()!=null) {
			p.setImage(productDTO.getImage());
		}
		p.setId(productDTO.getId());
		p.setProductDescription(productDTO.getProductDescription());
		p.setProductName(productDTO.getProductName());
		productDao.updateProduct(p);		
		
	}

	@Override
	public void deleteProduct(int id) {
		Product product= productDao.getProductbyId(id);
		if(product!=null) {
			productDao.deleteProduct(product);
		}
		
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> ps = productDao.getAllProduct();
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for(Product p:ps) {
			ProductDTO dto = new ProductDTO();
			dto.setId(p.getId());
			dto.setImage(p.getImage());
			dto.setProductName(p.getProductName());
			
//			ProductResourceDTO prDTO = new ProductResourceDTO();
//			prDTO.setId(p.getId());
			
			// goi ra resource
//			ResourceDTO resourceDTO = new ResourceDTO();
//			resourceDTO.setId(p.getCategory().getId());
//			resourceDTO.setCategoryName(r.getCategory().getCategoryName());
//			dto.setCategory(resourceDTO);
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public ProductDTO getProductbyId(int id) {
		ProductDTO productDTO =new ProductDTO();
		Product product= productDao.getProductbyId(id);
		productDTO.setId(product.getId());
		productDTO.setImage(product.getImage());
		productDTO.setProductName(product.getProductName());
		List<ProductResource> productResources= productResourceDAO.getProductResourceByProductId(id);
		List<ResourceDTO> resourceDTOs= new ArrayList<>();
		List<String> strings = new ArrayList<>();
		for(ProductResource productResource:productResources) {
			ResourceDTO dto= new ResourceDTO();
			dto.setId(productResource.getResource().getId());
			dto.setResourceName(productResource.getResource().getResourceName());
			resourceDTOs.add(dto);
			strings.add(productResource.getResource().getResourceName());
		}
		productDTO.setResource(resourceDTOs);
		productDTO.setResources(strings);
		productDTO.setProductDescription(product.getProductDescription());
		return productDTO;
	}

}
