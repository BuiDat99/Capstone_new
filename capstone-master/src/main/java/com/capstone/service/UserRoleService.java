package com.capstone.service;

import java.util.List;

import com.capstone.model.AppUserDTO;
import com.capstone.model.UserRoleDTO;

public interface UserRoleService {
	public void addUserRole(UserRoleDTO userRole);
	
	public void updateUserRole(AppUserDTO appUserDTO);
	
	public void deleteUserRole(AppUserDTO appUserDTO);
	
	public List<UserRoleDTO> getAllUserRole();
	
	public UserRoleDTO getUserRolebyId(int id);
}
