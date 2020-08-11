package com.capstone.model;

public class AppRoleDTO {

	private int id;
	private String roleName;
	
	public AppRoleDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppRoleDTO(int id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
