package com.capstone.dao;

import java.util.List;

import com.capstone.entity.AppRole;

public interface AppRoleDAO {
	 
	public List<String> getRoleNames( int userId);
	
	List<AppRole> getAllAppRole ();
	
}
