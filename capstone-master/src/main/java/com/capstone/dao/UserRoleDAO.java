package com.capstone.dao;

import java.util.List;

import com.capstone.entity.UserRole;

public interface UserRoleDAO {

public void addUserRole(UserRole userRole);
	
	public void updateUserRole(UserRole userRole);
	
	public void deleteUserRole(UserRole userRole);
	
	public List<UserRole> getAllUserRole();
	
	public UserRole getUserRolebyId(int id);
}
