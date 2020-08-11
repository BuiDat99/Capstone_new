package com.capstone.entity;

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

@Entity
@Data
@Table(name="User_History")
public class UserHistory {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_History_Id", nullable = false)
    private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_Id", nullable = false)
    private AppUser appUser;
	
	@Column(name = "height", nullable = false)
	private float height;
	
	@Column(name = "weight", nullable = false)
	private float weight;
	
	@Column(name = "bmi", nullable = false)
	private float bmi;
	
	@Column(name = "desire", length = 255, nullable = false)
	private String desire;
	
	@Column(name = "track_Results", length = 255, nullable = false)
	private String track_Results;
	
	@Column(name = "creation_Date", nullable = false)
	private String creation_Date;
}
