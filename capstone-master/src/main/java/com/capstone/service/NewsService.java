package com.capstone.service;

import java.util.List;

import com.capstone.model.NewsDTO;

public interface NewsService {

	public void addNews(NewsDTO news);
	
	public void updateNews(NewsDTO newsDTO);
	
	public void deleteNews(int id);
	
	public List<NewsDTO> getAllNews(String enable);
	
	public List<NewsDTO> getTop6News(String enable);
	
	public List<NewsDTO> getTop4NewsByDate(String enable);
	
	public List<NewsDTO> getAllNewsOfCat(String enable,int catId, int start, int length);
	
	public int countNewsOfCategory(String enable,int id);
	
	public NewsDTO getNewsbyId(int id);
	
	public List<NewsDTO> search(String enable,String findName, int start, int length);
	
	public int countNewsWhensearch(String enable,String name);
}
