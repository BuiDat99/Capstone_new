package com.capstone.dao;

import java.util.List;

import com.capstone.entity.MenuProduct;

public interface MenuProductDAO {

	public void addMenuProduct(MenuProduct menuProduct);
	
	public void updateMenuProduct(MenuProduct menuProduct);
	
	public void deleteMenuProduct(MenuProduct menuProduct);
	
	public List<MenuProduct> getAllMenuProduct();
	
	public MenuProduct getMenuProductbyId(int id);
}
