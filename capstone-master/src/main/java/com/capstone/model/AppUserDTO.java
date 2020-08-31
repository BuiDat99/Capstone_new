package com.capstone.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class AppUserDTO {

	private int userId;
	private String username;
	private String password;
	private String email;	
	private String enable;
	private List<String> roles;
	private String address;
	private String name;
	private String avata;
	private MultipartFile file;
	private String date_Of_Birth;
	private String gender;
	
	public AppUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppUserDTO(int userId, String username, String password, String email, String enable, List<String> roles,
			String address, String name, String avata, MultipartFile file, String date_Of_Birth, String gender) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enable = enable;
		this.roles = roles;
		this.address = address;
		this.name = name;
		this.avata = avata;
		this.file = file;
		this.date_Of_Birth = date_Of_Birth;
		this.gender = gender;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvata() {
		return avata;
	}

	public void setAvata(String avata) {
		this.avata = avata;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getDate_Of_Birth() {
		return date_Of_Birth;
	}

	public void setDate_Of_Birth(String date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
}