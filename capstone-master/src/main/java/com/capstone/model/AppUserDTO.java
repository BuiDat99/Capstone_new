package com.capstone.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
}