package com.capstone.model;


public class UserRoleDTO {
	private int id;
	private AppUserDTO user;
	private AppRoleDTO role;
	
	public UserRoleDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserRoleDTO(int id, AppUserDTO user, AppRoleDTO role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppUserDTO getUser() {
		return user;
	}

	public void setUser(AppUserDTO user) {
		this.user = user;
	}

	public AppRoleDTO getRole() {
		return role;
	}

	public void setRole(AppRoleDTO role) {
		this.role = role;
	}
	
	
}
