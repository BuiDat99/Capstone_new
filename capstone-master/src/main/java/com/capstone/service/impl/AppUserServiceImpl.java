package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capstone.dao.AppRoleDAO;
import com.capstone.dao.AppUserDAO;
import com.capstone.dao.UserRoleDAO;
import com.capstone.entity.AppRole;
import com.capstone.entity.AppUser;
import com.capstone.entity.UserRole;
import com.capstone.google.GooglePojo;
import com.capstone.google.GoogleUtils;
import com.capstone.model.AppUserDTO;
import com.capstone.repository.AppUserRepository;
import com.capstone.service.AppUserService;

@Transactional
@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private GoogleUtils googleUtils;
	@Autowired
	private AppUserDAO userDao;
	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private UserRoleDAO userRoleDao;
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	 @Override
	    public AppUser findUserByEmail(final String email) {
	        return userRepository.findByEmail(email);
	    }
	 @Override
	    public boolean checkIfValidOldPassword(final AppUser user, final String oldPassword) {
	        return passwordEncoder.matches(oldPassword, user.getEncrytedPassword());
	    }
	 @Override
	    public void changeUserPassword(final AppUser user, final String password) {
	        user.setEncrytedPassword(passwordEncoder.encode(password));
	        userRepository.save(user);
	    }
	@Override
	public void insert(AppUserDTO userDTO) {
		AppUser user = new AppUser();	
		
		user.setUserName(userDTO.getUsername());
		user.setEncrytedPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setEnabled(userDTO.getEnable());
		userDao.insert(user);
		
		AppRole r = new AppRole();
		r.setRoleId(2);		
		
		UserRole ur = new UserRole();
		ur.setAppUser(user);
		ur.setAppRole(r);
		
		
		userRoleDao.addUserRole(ur);
	}

	@Override
	public void insertWithLoginGoogle(AppUserDTO userDTO) {
		AppUser user = new AppUser();	
						
		user.setUserName(userDTO.getUsername());
		user.setEncrytedPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		user.setEnabled(userDTO.getEnable());
		userDao.insert(user);
		
		AppRole r = new AppRole();
		r.setRoleId(2);		
		
		UserRole ur = new UserRole();
		ur.setAppUser(user);
		ur.setAppRole(r);
		
		
		userRoleDao.addUserRole(ur);
		
	}
	@Override
	public AppUserDTO get(int id) {
		AppUser user = userDao.get(id);
		AppUserDTO dto = new AppUserDTO();
		dto.setUserId(user.getUserId());
		dto.setUsername(user.getUserName());
		dto.setPassword(user.getEncrytedPassword());
		dto.setEmail(user.getEmail());
		
		return dto;
	}
	
	@Override
	public void update(AppUserDTO userDTO) {
		AppUser user = userDao.get(userDTO.getUserId());
		if(user != null) {
			user.setUserName(userDTO.getUsername());
			user.setEncrytedPassword(userDTO.getPassword());
			user.setEmail(userDTO.getEmail());
			user.setEnabled(userDTO.getEnable());
			userDao.update(user);

			
		}
		
	}

	@Override
	public void delete(int id) {
		AppUser user = userDao.get(id);
		if(user != null) {
			userDao.delete(user);
		}
		
	}

	@Override
	public List<AppUserDTO> search(String name, int start, int length) {
		List<AppUser> users = userDao.search(name, start, length);
		List<AppUserDTO> dtos = new ArrayList<AppUserDTO>();
		for(AppUser u : users) {
			AppUserDTO dto = new AppUserDTO();
			dto.setUserId(u.getUserId());
			dto.setUsername(u.getUserName());
			dto.setPassword(u.getEncrytedPassword());
			dto.setEmail(u.getEmail());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override  //them dong nay`
	public boolean checkExistUser(String name) {
		AppUser user = userDao.findUserAccount(name);
		boolean check = false;
		if(user != null) {
			check = true;
		}
		return check;
	}

	@Override   //them dong nay`
	public boolean checkExistUserEmail(String email) {
		AppUser user = userDao.findUserAccountEmail(email);
		boolean check = false;
		if(user != null) {
			check = true;
		}
		return check;
	}
	@Override
	public List<AppUserDTO> getAllUser() {
		List<AppUser> users = userDao.getAllUser();
		List<AppUserDTO> dtos = new ArrayList<AppUserDTO>();
		for(AppUser u: users) {
			AppUserDTO dto = new AppUserDTO();
			dto.setUserId(u.getUserId());
			dto.setUsername(u.getUserName());
			dto.setEmail(u.getEmail());
			dto.setPassword(u.getEncrytedPassword());
			dto.setEnable(u.getEnabled());
						
			dtos.add(dto);
		}
		return dtos;
	}
	

}
