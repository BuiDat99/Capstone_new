package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.MenuProductDAO;
import com.capstone.entity.MenuProduct;
import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.model.ProductDTO;
import com.capstone.service.MenuProductService;

@Service
@Transactional
public class MenuProductServiceImpl implements MenuProductService {

	@Autowired
	private MenuProductDAO mpDao;
	@Override
	public void addMenuProduct(MenuProductDTO menuProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMenuProduct(MenuProductDTO menuProduct) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMenuProduct(int id) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

	
}
