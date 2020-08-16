package com.capstone.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.AppRoleDAO;
import com.capstone.entity.AppRole;
import com.capstone.model.AppRoleDTO;

public interface AppRoleService {
	List<AppRoleDTO> getAllAppRole ();
}

@Transactional
@Service
class AppRoleServiceImpl implements AppRoleService{

	@Autowired
	private AppRoleDAO appRoleDAO;
	
	@Override
	public List<AppRoleDTO> getAllAppRole() {
		List<AppRoleDTO> appRoleDTOs= new ArrayList<AppRoleDTO>();
		List<AppRole> appRoles= appRoleDAO.getAllAppRole();
		for(AppRole appRole:appRoles) {
			AppRoleDTO appRoleDTO= new AppRoleDTO();
			appRoleDTO.setId(appRole.getRoleId());
			appRoleDTO.setRoleName(appRole.getRoleName());
			appRoleDTOs.add(appRoleDTO);
		}
		return appRoleDTOs;
	}
	
	
}