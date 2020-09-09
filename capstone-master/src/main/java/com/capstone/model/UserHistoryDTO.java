package com.capstone.model;

public class UserHistoryDTO {
    private int id;
    private AppUserDTO appUser;
	private String height;
	private String weight;
	private String bmi;
	private String desire;
	private String track_Results;
	private String creation_Date;
	public UserHistoryDTO() {
		super();
	}
	public UserHistoryDTO(int id) {
		super();
		this.id = id;
	}
	public UserHistoryDTO(int id, AppUserDTO appUser, String height, String weight, String bmi, String desire,
			String track_Results, String creation_Date) {
		super();
		this.id = id;
		this.appUser = appUser;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.desire = desire;
		this.track_Results = track_Results;
		this.creation_Date = creation_Date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AppUserDTO getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUserDTO appUser) {
		this.appUser = appUser;
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
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	
	
}
