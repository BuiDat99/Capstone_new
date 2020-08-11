package com.capstone.dao;

import java.util.List;

import com.capstone.entity.HashtagStandard;

public interface HashtagDAO {

	public void addTag(HashtagStandard tag);
	
	public void updateTag(HashtagStandard tag);
	
	public void deleteTag(HashtagStandard tag);
	
	public List<HashtagStandard> getAllTags();
	
	public HashtagStandard getTagbyId(int id);
	
	public List<HashtagStandard> search(String findName, int start, int length);
	
	public int countTagWhensearch(String name);
}
