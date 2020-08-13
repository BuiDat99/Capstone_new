package com.capstone.service;

import java.util.List;

import com.capstone.model.HashTagDTO;

public interface HashTagService {

	public void addTag(HashTagDTO tag);
	
	public void updateTag(HashTagDTO tagDTO);
	
	public void deleteTag(int id);
	
	public List<HashTagDTO> getAllTags(String enable);
	
	public  HashTagDTO getTagbyId(int id);
	
	public List<HashTagDTO> search(String enable,String name, int start, int length);
	
	public int countTagWhensearch(String enable,String name);
}
