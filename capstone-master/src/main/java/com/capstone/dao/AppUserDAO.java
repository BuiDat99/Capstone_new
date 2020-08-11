package com.capstone.dao;

import java.util.List;

import com.capstone.entity.AppUser;

public interface AppUserDAO {

	public void insert(AppUser user);

	public void update(AppUser user);

	public void delete(AppUser user);

	public AppUser get(int id);
	
	public List<AppUser> getAllUser();

	public List<AppUser> search(String findName, int start, int length);

	public AppUser findUserAccount(String userName);

	public AppUser findAppUserbyUserName(String username);

	public AppUser findUserAccountEmail(String email);
	

}
