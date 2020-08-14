package com.capstone.service;

import java.util.List;

import com.capstone.entity.AppUser;
import com.capstone.model.AppUserDTO;

public interface AppUserService {
	
	AppUser findUserByEmail(String email);
	
	boolean checkIfValidOldPassword(AppUser user, String password);

	void changeUserPassword(AppUserDTO userDTO);

	void insert(AppUserDTO userDTO);
	
	void insertWithLoginGoogle(AppUserDTO userDTO);

	void update(AppUserDTO userDTO);

	void delete(int id);

	AppUserDTO get(int id);
	
	public List<AppUserDTO> getAllUser();
	
	List<AppUserDTO> search(String name, int start, int length);

	boolean checkExistUser(String name);

	boolean checkExistUserEmail(String name);
	
	void resetUserPassword( AppUserDTO userDTO);

	

}
