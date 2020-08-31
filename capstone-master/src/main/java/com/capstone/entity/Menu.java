package com.capstone.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_Id", nullable = false)
	private int id;
	
	@Column(name = "hashtag", length = 50, nullable = false)
	private String hashtag;
	
	@Column(name = "menu_Name", length = 100, nullable = false)
	private String menuName;
	
	@Column(name = "menu_Description", length = 255, nullable = false)
	private String menu_Description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_Id")
	private AppUser user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu",cascade = CascadeType.REMOVE)
	private List<MenuProduct> menuProducts;
	
	@Column(name = "enable", length = 50)
    private String enable;

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

	public String getMenu_Description() {
		return menu_Description;
	}

	public void setMenu_Description(String menu_Description) {
		this.menu_Description = menu_Description;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public List<MenuProduct> getMenuProducts() {
		return menuProducts;
	}

	public void setMenuProducts(List<MenuProduct> menuProducts) {
		this.menuProducts = menuProducts;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	
}
