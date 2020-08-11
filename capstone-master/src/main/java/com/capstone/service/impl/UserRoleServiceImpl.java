package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.UserRoleDAO;
import com.capstone.entity.UserRole;
import com.capstone.model.AppRoleDTO;
import com.capstone.model.AppUserDTO;
import com.capstone.model.UserRoleDTO;
import com.capstone.service.UserRoleService;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDAO userRoleDao;
	@Override
	public void addUserRole(UserRoleDTO userRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserRole(UserRoleDTO userRole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserRole(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserRoleDTO> getAllUserRole() {
		List<UserRole> urs = userRoleDao.getAllUserRole();
		List<UserRoleDTO> dtos = new ArrayList<UserRoleDTO>();
		for(UserRole ur: urs) {
			UserRoleDTO dto = new UserRoleDTO();
			dto.setId(ur.getId());
			
			AppUserDTO udto = new AppUserDTO();
			udto.setUserId(ur.getAppUser().getUserId());
			udto.setUsername(ur.getAppUser().getUserName());
			dto.setUser(udto);
			
			AppRoleDTO rdto = new AppRoleDTO();
			rdto.setId(ur.getAppRole().getRoleId());
			rdto.setRoleName(ur.getAppRole().getRoleName());
			dto.setRole(rdto);
			
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public UserRoleDTO getUserRolebyId(int id) {
		UserRole ur = userRoleDao.getUserRolebyId(id);
		UserRoleDTO dto = new UserRoleDTO();
		dto.setId(ur.getId());
		
		AppUserDTO udto = new AppUserDTO();
		udto.setUserId(ur.getAppUser().getUserId());
		dto.setUser(udto);
		
		AppRoleDTO rdto = new AppRoleDTO();
		rdto.setId(ur.getAppRole().getRoleId());
		dto.setRole(rdto);
		
		return dto;
	}
}
