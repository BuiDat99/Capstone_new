package com.capstone.service;

import java.util.List;

import com.capstone.model.MenuDTO;

public interface MenuService {

	public void addMenu(MenuDTO menu);
	
	public void updateMenu(MenuDTO menu);
	
	public void deleteMenu(int id);
	
	public List<MenuDTO> getAllMenu(String has,String enable);
	
	public MenuDTO getMenubyId(int id);
	
	public List<MenuDTO> getAllMenubyuser(String has,String enable,int uId);
	
	public List<MenuDTO> search(String hashtag,String enable,String findName, int start, int length);
	
	public int countMenuWhensearch(String h,String enable,String name);

}
