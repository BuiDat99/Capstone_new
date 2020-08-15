package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ProductDAO;
import com.capstone.dao.ProductResourceDAO;
import com.capstone.dao.ResourceDAO;
import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ProductService;
import com.capstone.service.ResourceService;

@Service
@Transactional
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private ResourceService resourceDao;
	
	@Autowired
	private ProductResourceDAO productResourceDAO;
	
	@Override
	public void addProduct(ProductDTO productDTO) {
		Product p = new Product();
		p.setImage(productDTO.getImage());
		p.setProductName(productDTO.getProductName());
		p.setEnable("1");
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
		Product p =productDao.getProductbyId(productDTO.getId());
		
		p.setImage(productDTO.getImage());
		p.setProductDescription(productDTO.getProductDescription());
		p.setProductName(productDTO.getProductName());
		p.setEnable(productDTO.getEnable());
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
	public List<ProductDTO> getAllProducts(String enable) {
		List<Product> ps = productDao.getAllProduct(enable);
		List<ProductDTO> dtos = new ArrayList<ProductDTO>();
		for(Product p:ps) {
			ProductDTO dto = new ProductDTO();
			dto.setId(p.getId());
			dto.setImage(p.getImage());
			dto.setProductName(p.getProductName());
			dto.setEnable(p.getEnable());
			List<ProductResource> resources=p.getProductResources();
			List<ProductResourceDTO> resourceDTOs= new ArrayList<ProductResourceDTO>();
			for(ProductResource resource:resources) {
				ProductResourceDTO resourceDTO = new ProductResourceDTO();
				resourceDTO.setGram(resource.getKcal1g());
				ResourceDTO resourceDTO2= resourceDao.getResourcebyId(resource.getResource().getId());
				resourceDTO.setResource(resourceDTO2);
				resourceDTOs.add(resourceDTO);
			}
//			ProductResourceDTO prDTO = new ProductResourceDTO();
//			prDTO.setId(p.getId());
			dto.setProductResourceDTOs(resourceDTOs);
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
		productDTO.setEnable(product.getEnable());
		productDTO.setResource(resourceDTOs);
		productDTO.setResources(strings);
		productDTO.setProductDescription(product.getProductDescription());
		return productDTO;
	}

}
