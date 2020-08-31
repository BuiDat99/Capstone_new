package com.capstone.model;

public class HashTagDTO {

	private int tagId;
	private String tagCode;
	private String tagContent;
	private String enable;
	public HashTagDTO() {
		// TODO Auto-generated constructor stub
	}
	public HashTagDTO(int tagId, String tagCode, String tagContent, String enable) {
		super();
		this.tagId = tagId;
		this.tagCode = tagCode;
		this.tagContent = tagContent;
		this.enable = enable;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagCode() {
		return tagCode;
	}
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}
	public String getTagContent() {
		return tagContent;
	}
	public void setTagContent(String tagContent) {
		this.tagContent = tagContent;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	
	
	
}
