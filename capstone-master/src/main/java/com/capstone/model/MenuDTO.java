package com.capstone.model;

import java.util.List;

import lombok.Data;

@Data
public class MenuDTO {

	private int id;
	private String hashtag;
	private String menuName;
	private AppRoleDTO role;
	private String menuDescription;
	private int userId;
	private List<MenuProductDTO> menuProductDTOs;
	private List<String> listproductId;
	private String enable;
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}
	

	public MenuDTO(int id, String hashtag, String menuName, AppRoleDTO role) {
		super();
		this.id = id;
		this.hashtag = hashtag;
		this.menuName = menuName;
		this.role = role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public AppRoleDTO getRole() {
		return role;
	}

	public void setRole(AppRoleDTO role) {
		this.role = role;
	}
	
	
}
