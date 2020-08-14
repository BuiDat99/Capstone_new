package com.capstone.dao;

import java.util.List;

import com.capstone.entity.News;

public interface NewsDAO {
	
	public void addNews(News news);
	
	public void updateNews(News news);
	
	public void deleteNews(News news);
	
	public List<News> getAllNews(String enable);
	
	public List<News> getTop6News(String enable);
	
	public List<News> getTop4NewsByDate(String enable);
	
	public List<News> getAllNewsOfCat(String enable,int catId, int start, int length);
	
	public int countNewsOfCategory(String h,String enable,int id);
	
	public News getNewsbyId(int id);
	
	public List<News> search(String hash,String enable, String findName, int start, int length);
	
	public int countNewsWhensearch(String h,String enable,String name);

}
