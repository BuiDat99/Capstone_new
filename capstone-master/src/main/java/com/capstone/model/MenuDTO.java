package com.capstone.model;

import java.util.List;

public class MenuDTO {

	private int id;
	private String hashtag;
	private String menuName;
	private AppRoleDTO role;
	private String menuDescription;
	private int userId;
	private String userName;
	private List<MenuProductDTO> menuProductDTOs;
	private List<String> listproductId;
	private String enable;
	public MenuDTO() {
		// TODO Auto-generated constructor stub
	}
	public MenuDTO(int id, String hashtag, String menuName, AppRoleDTO role, String menuDescription, int userId,
			String userName, List<MenuProductDTO> menuProductDTOs, List<String> listproductId, String enable) {
		super();
		this.id = id;
		this.hashtag = hashtag;
		this.menuName = menuName;
		this.role = role;
		this.menuDescription = menuDescription;
		this.userId = userId;
		this.userName = userName;
		this.menuProductDTOs = menuProductDTOs;
		this.listproductId = listproductId;
		this.enable = enable;
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
	public String getMenuDescription() {
		return menuDescription;
	}
	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<MenuProductDTO> getMenuProductDTOs() {
		return menuProductDTOs;
	}
	public void setMenuProductDTOs(List<MenuProductDTO> menuProductDTOs) {
		this.menuProductDTOs = menuProductDTOs;
	}
	public List<String> getListproductId() {
		return listproductId;
	}
	public void setListproductId(List<String> listproductId) {
		this.listproductId = listproductId;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	

	
	
	
}
