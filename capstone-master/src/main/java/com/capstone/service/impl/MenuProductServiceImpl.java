package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.MenuDAO;
import com.capstone.dao.MenuProductDAO;
import com.capstone.dao.ProductDAO;
import com.capstone.entity.Menu;
import com.capstone.entity.MenuProduct;
import com.capstone.entity.Product;
import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.model.ProductDTO;
import com.capstone.service.MenuProductService;

@Service
@Transactional
public class MenuProductServiceImpl implements MenuProductService {

	@Autowired
	private MenuProductDAO mpDao;
	
	@Autowired
	private MenuDAO menuDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@Override
	public void addMenuProduct(MenuProductDTO menuProductDTO) {
		MenuProduct menuProduct= new MenuProduct();
		Menu menu= menuDAO.getMenubyId(menuProductDTO.getMenu().getId());
		Product product= productDAO.getProductbyId(menuProductDTO.getProduct().getId());
		menuProduct.setMenu(menu);
		menuProduct.setProduct(product);
		mpDao.addMenuProduct(menuProduct);
		menuProductDTO.setId(menuProduct.getId());
		
	}

	@Override
	public void updateMenuProduct(MenuProductDTO menuProductDTO) {
		MenuProduct menuProduct= mpDao.getMenuProductbyId(menuProductDTO.getId());
		if(menuProduct!=null) {
			Menu menu= menuDAO.getMenubyId(menuProductDTO.getMenu().getId());
			Product product= new Product();
			product= productDAO.getProductbyId(menuProductDTO.getProduct().getId());
			menuProduct.setMenu(menu);
			menuProduct.setProduct(product);
			mpDao.updateMenuProduct(menuProduct);;
		}
		
	}

	@Override
	public void deleteMenuProduct(int id) {
		MenuProduct menuProduct= mpDao.getMenuProductbyId(id);
		if(menuProduct!=null) {
			mpDao.deleteMenuProduct(menuProduct);
		}
		
	}

	@Override
	public List<MenuProductDTO> getAllMenuProduct() {
		List<MenuProduct> mps = mpDao.getAllMenuProduct();
		List<MenuProductDTO> dtos = new ArrayList<MenuProductDTO>();
		for(MenuProduct mp: mps) {
			MenuProductDTO dto = new MenuProductDTO();
			dto.setId(mp.getId());
			
			ProductDTO pdto = new ProductDTO();
			pdto.setId(mp.getProduct().getId());
			pdto.setProductName(mp.getProduct().getProductName());
			pdto.setImage(mp.getProduct().getImage());
			dto.setProduct(pdto);
			
			MenuDTO mdto = new MenuDTO();
			mdto.setId(mp.getMenu().getId());
//			mdto.setResourceName(mp.getResource().getResourceName());		
			dto.setMenu(mdto);
			
			
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public MenuProductDTO getMenuProductbyId(int id) {
		MenuProduct mp= mpDao.getMenuProductbyId(id);
		MenuProductDTO dto = new MenuProductDTO();
		dto.setId(mp.getId());
		
		ProductDTO pdto = new ProductDTO();
		pdto.setId(mp.getProduct().getId());
		pdto.setProductName(mp.getProduct().getProductName());
		pdto.setImage(mp.getProduct().getImage());
		dto.setProduct(pdto);
		
		MenuDTO mdto = new MenuDTO();
		mdto.setId(mp.getMenu().getId());
//		mdto.setResourceName(mp.getResource().getResourceName());		
		dto.setMenu(mdto);
		return dto;
	}

	
}
