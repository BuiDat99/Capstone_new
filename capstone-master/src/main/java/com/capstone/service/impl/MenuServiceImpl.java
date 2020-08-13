package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.AppUserDAO;
import com.capstone.dao.MenuDAO;
import com.capstone.dao.ProductDAO;
import com.capstone.entity.Menu;
import com.capstone.entity.MenuProduct;
import com.capstone.entity.Product;
import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.model.ProductDTO;
import com.capstone.service.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDAO menuDao;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private  AppUserDAO appUserDAO;
	@Override
	public void addMenu(MenuDTO menu) {
		Menu menu2= new Menu();
		menu2.setMenu_Description(menu.getMenuDescription());
		menu2.setMenuName(menu.getMenuName());
		menu2.setHashtag(menu.getHashtag());
		menu2.setUser(appUserDAO.get(menu.getUserId()));
		menu2.setEnable("1");
		menuDao.addMenu(menu2);
		menu.setId(menu2.getId());
	}

	@Override
	public void updateMenu(MenuDTO menu) {
		Menu menu2=menuDao.getMenubyId(menu.getId());
		if(menu2!=null) {
			menu2.setMenu_Description(menu.getMenuDescription());
			menu2.setMenuName(menu.getMenuName());
			menu2.setHashtag(menu.getHashtag());
			menu2.setUser(appUserDAO.get(menu.getUserId()));
			menu2.setEnable(menu.getEnable());
			menuDao.updateMenu(menu2);
		}
		
	}

	@Override
	public void deleteMenu(int id) {
		Menu menu2=menuDao.getMenubyId(id);
		if(menu2!=null) {
			menuDao.deleteMenu(menu2);
		}
		
	}

	@Override
	public List<MenuDTO> getAllMenu(String a) {
		List<Menu> ms = menuDao.getAllMenu(a);
		List<MenuDTO> dtos = new ArrayList<MenuDTO>();
		for(Menu m:ms) {
			MenuDTO dto = new MenuDTO();
			dto.setId(m.getId());
			dto.setHashtag(m.getHashtag());
			dto.setMenuName(m.getMenuName());
// thieu set role
//			dto.setRole(m.getRole().getRoleId());
			dto.setEnable(m.getEnable());
			dto.setUserId(m.getUser().getUserId());
			List<MenuProductDTO> menuProductDTOs= new ArrayList<MenuProductDTO>();
			List<MenuProduct> menuProducts= m.getMenuProducts();
			for(MenuProduct menuProduct:menuProducts) {
				MenuProductDTO menuProductDTO= new MenuProductDTO();
				menuProductDTO.setId(menuProduct.getId());
				Menu menu= menuDao.getMenubyId(menuProduct.getMenu().getId());
				MenuDTO menuDTO= new MenuDTO();
				menuDTO.setId(menu.getId());
				Product product = productDAO.getProductbyId(menuProduct.getProduct().getId());
				ProductDTO productDTO= new ProductDTO();
				productDTO.setId(product.getId());
				productDTO.setProductName(product.getProductName());
				menuProductDTO.setMenu(menuDTO);
				menuProductDTO.setProduct(productDTO);
				menuProductDTOs.add(menuProductDTO);
				dto.setMenuProductDTOs(menuProductDTOs);
			}
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public MenuDTO getMenubyId(int id) {
		MenuDTO menuDTO= new MenuDTO();
		Menu menu= menuDao.getMenubyId(id);
		menuDTO.setId(menu.getId());
		menuDTO.setMenuDescription(menu.getMenu_Description());
		menuDTO.setMenuName(menu.getMenuName());
		menuDTO.setHashtag(menu.getHashtag());
		menuDTO.setUserId(menu.getUser().getUserId());
		menuDTO.setEnable(menu.getEnable());
		List<MenuProduct> menuProducts= menu.getMenuProducts();
		List<MenuProductDTO> menuProductDTOs= new ArrayList<MenuProductDTO>();
		for(MenuProduct menuProduct:menuProducts) {
			MenuProductDTO menuProductDTO= new MenuProductDTO();
			menuProductDTO.setId(menuProduct.getId());
			Menu menu1= menuDao.getMenubyId(menuProduct.getMenu().getId());
			MenuDTO menuDTO1= new MenuDTO();
			menuDTO1.setId(menu1.getId());
			Product product = productDAO.getProductbyId(menuProduct.getProduct().getId());
			ProductDTO productDTO= new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setProductName(product.getProductName());
			menuProductDTO.setMenu(menuDTO1);
			menuProductDTO.setProduct(productDTO);
			menuProductDTOs.add(menuProductDTO);
			menuDTO.setMenuProductDTOs(menuProductDTOs);
		}
		return menuDTO;
	}

}
