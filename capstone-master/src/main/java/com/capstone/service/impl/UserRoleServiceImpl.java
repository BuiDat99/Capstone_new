package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.AppUserDAO;
import com.capstone.dao.UserRoleDAO;
import com.capstone.entity.AppRole;
import com.capstone.entity.AppUser;
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
	
	@Autowired
	private AppUserDAO appUserDao;
	@Override
	public void addUserRole(UserRoleDTO userRole) {
		UserRole userRole2= new UserRole();
		AppRole appRole= new AppRole();
		appRole.setRoleId(userRole.getRole().getId());
		userRole2.setAppRole(appRole);
		AppUser appUser= new AppUser();
		appUser.setUserId(userRole.getUser().getUserId());
		userRole2.setAppUser(appUser);
		userRoleDao.addUserRole(userRole2);
	}

	@Override
	public void deleteUserRole(AppUserDTO appUserDTO) {
		AppUser user = appUserDao.get(appUserDTO.getUserId());
		user.getUserRoles().clear();
		appUserDao.update(user);
	}

	@Override
	public void updateUserRole(AppUserDTO appUserDTO) {
		AppUser user = appUserDao.get(appUserDTO.getUserId());

		List<UserRole> roles = new ArrayList<UserRole>();
		for (String roleId : appUserDTO.getRoles()) {
			UserRole userRole = new UserRole();
			userRole.setAppUser(user);
			userRole.setAppRole(new AppRole(Integer.parseInt(roleId)));

			roles.add(userRole);
		}

		user.getUserRoles().addAll(roles);
		
		appUserDao.update(user);
	}

//	@Override
//	public void deleteUserRole(int id) {
//		UserRole role= userRoleDao.getUserRolebyId(id);
//		if(role!=null) {
//			userRoleDao.deleteUserRole(role);
//		}
//		
//	}

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
