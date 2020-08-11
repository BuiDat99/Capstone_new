package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.NewsDAO;
import com.capstone.entity.NewCategory;
import com.capstone.entity.News;
import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.service.NewsService;

@Transactional
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDao;
	@Override
	public void addNews(NewsDTO news) {
		News n = new News();
		n.setTitle(news.getTitle());
		n.setImageTitle(news.getImageTitle());
		n.setPoster(news.getPoster());
		n.setAuthor(news.getAuthor());
		n.setShortDescription(news.getShortDescription());
		n.setDetailDescription(news.getDetailDescription());
		n.setSource(news.getSource());
		n.setHashtag(news.getHashtag());
		n.setStatus(news.getStatus());
		n.setCreationDate(news.getCreationDate());
		n.setModifiedDate(news.getModifiedDate());
		
		NewCategory category = new NewCategory();
		category.setId(news.getCategory().getId());
		category.setCategoryName(news.getCategory().getCategoryName());
		n.setCategory(category);
		
		newsDao.addNews(n);
	}

	@Override
	public void updateNews(NewsDTO newsDTO) {
		News n = newsDao.getNewsbyId(newsDTO.getId());
		
		if(n != null) {
			n.setTitle(newsDTO.getTitle());
			n.setImageTitle(newsDTO.getImageTitle());
			n.setPoster(newsDTO.getPoster());
			n.setAuthor(newsDTO.getAuthor());
			n.setShortDescription(newsDTO.getShortDescription());
			n.setDetailDescription(newsDTO.getDetailDescription());
			n.setSource(newsDTO.getSource());
			n.setHashtag(newsDTO.getHashtag());
			n.setStatus(newsDTO.getStatus());
			n.setCreationDate(newsDTO.getCreationDate());
			n.setModifiedDate(newsDTO.getModifiedDate());
			
			NewCategory category = new NewCategory();
			category.setId(newsDTO.getCategory().getId());
			category.setCategoryName(newsDTO.getCategory().getCategoryName());
			n.setCategory(category);
			
			newsDao.updateNews(n);
		}
	}

	@Override
	public void deleteNews(int id) {
		News n = newsDao.getNewsbyId(id);
		if(n != null) {
			newsDao.deleteNews(n);
		}
		
	}

	@Override
	public List<NewsDTO> getAllNews() {
		List<News> ns = newsDao.getAllNews();
		List<NewsDTO> dtos = new ArrayList<NewsDTO>();
		for(News n: ns) {
			NewsDTO dto = new NewsDTO();
			dto.setId(n.getId());
			dto.setTitle(n.getTitle());
			dto.setImageTitle(n.getImageTitle());
			dto.setPoster(n.getPoster());
			dto.setAuthor(n.getAuthor());
			dto.setShortDescription(n.getShortDescription());
			dto.setDetailDescription(n.getDetailDescription());
			dto.setSource(n.getSource());
			dto.setHashtag(n.getHashtag());
			dto.setStatus(n.getStatus());
			dto.setCreationDate(n.getCreationDate());
			dto.setModifiedDate(n.getModifiedDate());
			
			NewCategoryDTO categoryDTO = new NewCategoryDTO();
			categoryDTO.setId(n.getCategory().getId());
			categoryDTO.setCategoryName(n.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
			
		}
		return dtos;
	}
	
	@Override
	public List<NewsDTO> getTop6News() {
		List<News> ns = newsDao.getTop6News();
		List<NewsDTO> dtos = new ArrayList<NewsDTO>();
		for(News n: ns) {
			NewsDTO dto = new NewsDTO();
			dto.setId(n.getId());
			dto.setTitle(n.getTitle());
			dto.setImageTitle(n.getImageTitle());
			dto.setPoster(n.getPoster());
			dto.setAuthor(n.getAuthor());
			dto.setShortDescription(n.getShortDescription());
			dto.setDetailDescription(n.getDetailDescription());
			dto.setSource(n.getSource());
			dto.setHashtag(n.getHashtag());
			dto.setStatus(n.getStatus());
			dto.setCreationDate(n.getCreationDate());
			dto.setModifiedDate(n.getModifiedDate());
			
			NewCategoryDTO categoryDTO = new NewCategoryDTO();
			categoryDTO.setId(n.getCategory().getId());
			categoryDTO.setCategoryName(n.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public NewsDTO getNewsbyId(int id) {
		News n = newsDao.getNewsbyId(id);
		NewsDTO dto = new NewsDTO();
		dto.setId(n.getId());
		dto.setTitle(n.getTitle());
		dto.setImageTitle(n.getImageTitle());
		dto.setPoster(n.getPoster());
		dto.setAuthor(n.getAuthor());
		dto.setShortDescription(n.getShortDescription());
		dto.setDetailDescription(n.getDetailDescription());
		dto.setSource(n.getSource());
		dto.setHashtag(n.getHashtag());
		dto.setStatus(n.getStatus());
		dto.setCreationDate(n.getCreationDate());
		dto.setModifiedDate(n.getModifiedDate());
		
		NewCategory category = new NewCategory();
		category.setId(n.getCategory().getId());
		category.setCategoryName(n.getCategory().getCategoryName());
		n.setCategory(category);
		
		return dto;
	}

	@Override
	public List<NewsDTO> search(String findName, int start, int length) {
		List<News> ns = newsDao.search(findName, start, length);
		List<NewsDTO> dtos = new ArrayList<NewsDTO>();
		for(News n: ns) {
			NewsDTO dto = new NewsDTO();
			dto.setId(n.getId());
			dto.setTitle(n.getTitle());
			dto.setImageTitle(n.getImageTitle());
			dto.setPoster(n.getPoster());
			dto.setAuthor(n.getAuthor());
			dto.setShortDescription(n.getShortDescription());
			dto.setDetailDescription(n.getDetailDescription());
			dto.setSource(n.getSource());
			dto.setHashtag(n.getHashtag());
			dto.setStatus(n.getStatus());
			dto.setCreationDate(n.getCreationDate());
			dto.setModifiedDate(n.getModifiedDate());
			
			NewCategoryDTO categoryDTO = new NewCategoryDTO();
			categoryDTO.setId(n.getCategory().getId());
			categoryDTO.setCategoryName(n.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public int countNewsWhensearch(String name) {		
		return newsDao.countNewsWhensearch(name);
	}

	@Override
	public int countNewsOfCategory(int id) {
		return newsDao.countNewsOfCategory(id);
	}

	@Override
	public List<NewsDTO> getTop4NewsByDate() {
		List<News> ns = newsDao.getTop4NewsByDate();
		List<NewsDTO> dtos = new ArrayList<NewsDTO>();
		for(News n: ns) {
			NewsDTO dto = new NewsDTO();
			dto.setId(n.getId());
			dto.setTitle(n.getTitle());
			dto.setImageTitle(n.getImageTitle());
			dto.setPoster(n.getPoster());
			dto.setAuthor(n.getAuthor());
			dto.setShortDescription(n.getShortDescription());
			dto.setDetailDescription(n.getDetailDescription());
			dto.setSource(n.getSource());
			dto.setHashtag(n.getHashtag());
			dto.setStatus(n.getStatus());
			dto.setCreationDate(n.getCreationDate());
			dto.setModifiedDate(n.getModifiedDate());
			
			NewCategoryDTO categoryDTO = new NewCategoryDTO();
			categoryDTO.setId(n.getCategory().getId());
			categoryDTO.setCategoryName(n.getCategory().getCategoryName());
			dto.setCategory(categoryDTO);
			
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public List<NewsDTO> getAllNewsOfCat(int catId, int start, int length) {
		List<News> ns = newsDao.getAllNewsOfCat(catId, start, length);
		List<NewsDTO> dtos = new ArrayList<NewsDTO>();
		for(News n: ns) {
			NewsDTO dto = new NewsDTO();
			dto.setId(n.getId());
			dto.setTitle(n.getTitle());
			dto.setImageTitle(n.getImageTitle());
			dto.setPoster(n.getPoster());
			dto.setAuthor(n.getAuthor());
			dto.setShortDescription(n.getShortDescription());
			dto.setDetailDescription(n.getDetailDescription());
			dto.setSource(n.getSource());
			dto.setHashtag(n.getHashtag());
			dto.setStatus(n.getStatus());
			dto.setCreationDate(n.getCreationDate());
			dto.setModifiedDate(n.getModifiedDate());
			dtos.add(dto);
		}
		return dtos;
	}

	

}
