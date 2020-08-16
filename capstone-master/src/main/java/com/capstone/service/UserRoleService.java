package com.capstone.service;

import com.capstone.model.AppUserDTO;

public interface UserRoleService {
	public void updateUserRole(AppUserDTO appUserDTO);

	void deleteUserRole(AppUserDTO appUserDTO);

}
