package com.capstone.model;

import java.util.List;

import lombok.Data;
@Data
public class AppUserDTO {

	private int userId;
	private String username;
	private String password;
	private String email;	
	private String enable;
	private List<String> roles;
	
	public AppUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppUserDTO(int userId, String username, String password, String email, String enable, List<String> roles) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enable = enable;
		this.roles = roles;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}