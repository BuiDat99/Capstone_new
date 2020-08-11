package com.capstone.service;

import java.util.List;

import com.capstone.model.NewsDTO;

public interface NewsService {

	public void addNews(NewsDTO news);
	
	public void updateNews(NewsDTO newsDTO);
	
	public void deleteNews(int id);
	
	public List<NewsDTO> getAllNews();
	
	public List<NewsDTO> getTop6News();
	
	public List<NewsDTO> getTop4NewsByDate();
	
	public List<NewsDTO> getAllNewsOfCat(int catId, int start, int length);
	
	public int countNewsOfCategory(int id);
	
	public NewsDTO getNewsbyId(int id);
	
	public List<NewsDTO> search(String findName, int start, int length);
	
	public int countNewsWhensearch(String name);
}
