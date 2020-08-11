package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.Data;

@Data
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
    
}
