package com.capstone.dao;

import java.util.List;

import com.capstone.entity.Menu;

public interface MenuDAO {

	public void addMenu(Menu menu);
	
	public void updateMenu(Menu menu);
	
	public void deleteMenu(Menu menu);
	
	public List<Menu> getAllMenu(String enable, String hashtag);
	
	public Menu getMenubyId(int id);
	
	public List<Menu> getAllMenubyUserId(String enable, String hashtag,int userId);
	
	public List<Menu> search(String hash,String enable, String findName, int start, int length);
	
	public int countMenuWhensearch(String h,String enable,String name);

}
