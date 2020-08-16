package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppRole;
import com.capstone.entity.AppUser;
import com.capstone.entity.UserRole;
import com.capstone.model.AppUserDTO;
import com.capstone.service.UserRoleService;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private AppUserDAO appUserDao;
	
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

}
