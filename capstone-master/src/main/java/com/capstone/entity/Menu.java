package com.capstone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
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
}
