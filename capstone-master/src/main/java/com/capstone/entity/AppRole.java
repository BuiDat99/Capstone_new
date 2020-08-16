package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor // tao 1 contructer ko du lieuj
@Table(name = "Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "Role_Name") })
public class AppRole {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_Id", nullable = false)
    private int roleId;
 
    @Column(name = "role_Name", length = 50, nullable = false)
    private String roleName;
    
    @Column(name = "enable", length = 50)
    private String enable;

	public AppRole(int roleId) {
		super();
		this.roleId = roleId;
	}
    
}
