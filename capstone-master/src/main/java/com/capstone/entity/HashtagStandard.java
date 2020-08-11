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
@Table(name="Hashtag_standard")
public class HashtagStandard implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hs_Id", nullable = false)
	private int tagId;
	
	@Column(name = "hashtag_Code", length = 50, nullable = false)
	private String tagCode;
	
	@Column(name = "hashtag_Content", length = 255, nullable = false)
	private String tagContent;
}
