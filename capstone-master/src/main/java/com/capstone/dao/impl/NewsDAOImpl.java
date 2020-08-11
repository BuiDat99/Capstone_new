package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.NewsDAO;
import com.capstone.entity.News;

@Transactional
@Repository
public class NewsDAOImpl implements NewsDAO {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addNews(News news) {
		entityManager.persist(news);
		
	}

	@Override
	public void updateNews(News news) {
		entityManager.merge(news);
		
	}

	@Override
	public void deleteNews(News news) {
		entityManager.remove(news);
		
	}

	@Override
	public List<News> getAllNews() {
		String jql = "select n from News n";
		return entityManager.createQuery(jql,News.class).getResultList();
	}
	
	@Override
	public List<News> getTop6News() {
		String jql = "select n from News n";
		return entityManager.createQuery(jql,News.class).setMaxResults(6).getResultList();
	}
	
	@Override
	public List<News> getTop4NewsByDate() {
		String jql = "select n from News n order by creationDate desc";
		return entityManager.createQuery(jql,News.class).setMaxResults(4).getResultList();
	}

	@Override
	public News getNewsbyId(int id) {
		return entityManager.find(News.class, id);
	}

	@Override
	public List<News> search(String findName, int start, int length) {
		String jql = "select n from News n where title like :title";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("title", "%" + findName + "%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countNewsWhensearch(String name) {
		String jql="select n from News n where title like :title";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("title", "%" + name + "%");
		return (int) query.getResultList().size();
	}

	@Override
	public int countNewsOfCategory(int id) {
		String jql="select n from News n inner join NewCategory c on c.id=n.category.id where n.category.id=:id";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("id",id);
		return (int) query.getResultList().size();
	}

	@Override
	public List<News> getAllNewsOfCat(int catId, int start, int length) {
		String jql="select n from News n where n.category.id=:catId";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("catId",catId);
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	

	

}
