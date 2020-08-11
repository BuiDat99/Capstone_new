package com.capstone.dao;

import java.util.List;

import com.capstone.entity.News;

public interface NewsDAO {
	
	public void addNews(News news);
	
	public void updateNews(News news);
	
	public void deleteNews(News news);
	
	public List<News> getAllNews();
	
	public List<News> getTop6News();
	
	public List<News> getTop4NewsByDate();
	
	public List<News> getAllNewsOfCat(int catId, int start, int length);
	
	public int countNewsOfCategory(int id);
	
	public News getNewsbyId(int id);
	
	public List<News> search(String findName, int start, int length);
	
	public int countNewsWhensearch(String name);

}
