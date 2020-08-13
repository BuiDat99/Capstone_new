package com.capstone.service;

import java.util.List;

import com.capstone.model.MenuDTO;

public interface MenuService {

	public void addMenu(MenuDTO menu);
	
	public void updateMenu(MenuDTO menu);
	
	public void deleteMenu(int id);
	
	public List<MenuDTO> getAllMenu(String enable);
	
	public MenuDTO getMenubyId(int id);
}
