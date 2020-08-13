package com.capstone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Posts_Category")
public class NewCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_Id", nullable = false)
	private int id;
	
	@Column(name = "category_Name", length = 255, nullable = false)
	private String categoryName;
	
	@Column(name = "enable", length = 50)
    private String enable;
}
