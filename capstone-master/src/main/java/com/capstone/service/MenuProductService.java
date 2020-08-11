package com.capstone.service;

import java.util.List;

import com.capstone.model.MenuProductDTO;

public interface MenuProductService {

	public void addMenuProduct(MenuProductDTO menuProduct);
	
	public void updateMenuProduct(MenuProductDTO menuProduct);
	
	public void deleteMenuProduct(int id);
	
	public List<MenuProductDTO> getAllMenuProduct();
	
	public MenuProductDTO getMenuProductbyId(int id);
}
