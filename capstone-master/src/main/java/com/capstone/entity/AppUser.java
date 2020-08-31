package com.capstone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "username") })
public class AppUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id", nullable = false)
    private int userId;
 	
    @Column(name = "username", length = 36, nullable = false)
    private String userName;
 	
    @Column(name = "password", length = 200, nullable = false)
    private String encrytedPassword;
 
    @Column(name = "enable", length = 1, nullable = false)
    private String enabled;    
   
    @Column(name="email", length = 128, nullable = false)
    private String email;
    
    @Column(name="name", length = 255, nullable = true)
    private String name;    
    
    @Column(name="image", length = 50, nullable = true)
    private String image;
    
    @Column(name="date_Of_Birth", length = 255, nullable = true)
    private String date_Of_Birth;
    
    @Column(name="gender", length = 50, nullable = true)
    private String gender;
    
    @Column(name="address", length = 255, nullable = true)
    private String address;
    
    @Column(name="hashtag", length = 255, nullable = true)
    private String hashtag;  
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "appUser",cascade = CascadeType.ALL, orphanRemoval = true)
   	private List<UserRole> userRoles;

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

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
    
    
    
}
