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

@Entity
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getBmi() {
		return bmi;
	}

	public void setBmi(float bmi) {
		this.bmi = bmi;
	}

	public String getDesire() {
		return desire;
	}

	public void setDesire(String desire) {
		this.desire = desire;
	}

	public String getTrack_Results() {
		return track_Results;
	}

	public void setTrack_Results(String track_Results) {
		this.track_Results = track_Results;
	}

	public String getCreation_Date() {
		return creation_Date;
	}

	public void setCreation_Date(String creation_Date) {
		this.creation_Date = creation_Date;
	}
	
	
	
}
