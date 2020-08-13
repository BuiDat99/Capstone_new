package com.capstone.model;

import lombok.Data;
@Data
public class UserHistoryDTO {
    private int id;
    private AppUserDTO appUser;
	private float height;
	private float weight;
	private float bmi;
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
	
	
}
