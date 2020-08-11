package com.capstone.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Menu_Product")
public class MenuProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pm_Id", nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name="product_Id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="menu_Id")
	private Menu menu; 
}
