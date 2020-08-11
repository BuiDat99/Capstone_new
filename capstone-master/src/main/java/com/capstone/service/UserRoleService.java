package com.capstone.service;

import java.util.List;

import com.capstone.model.UserRoleDTO;

public interface UserRoleService {
	public void addUserRole(UserRoleDTO userRole);
	
	public void updateUserRole(UserRoleDTO userRole);
	
	public void deleteUserRole(int id);
	
	public List<UserRoleDTO> getAllUserRole();
	
	public UserRoleDTO getUserRolebyId(int id);
}
