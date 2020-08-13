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
	public List<News> getAllNews(String enable) {
		String jql = "select n from News n where status like :status";
		return entityManager.createQuery(jql,News.class).setParameter("status","%"+ enable+"%").getResultList();
	}
	
	@Override
	public List<News> getTop6News(String enable) {
		String jql = "select n from News n status like :status";
		return entityManager.createQuery(jql,News.class).setParameter("status", "%"+ enable+"%").setMaxResults(6).getResultList();
	}
	
	@Override
	public List<News> getTop4NewsByDate(String enable) {
		String jql = "select n from News n where status like :status order by creationDate desc ";
		return entityManager.createQuery(jql,News.class).setParameter("status","%"+ enable+"%").setMaxResults(4).getResultList();
	}

	@Override
	public News getNewsbyId(int id) {
		return entityManager.find(News.class, id);
	}

	@Override
	public List<News> search(String enable,String findName, int start, int length) {
		String jql = "select n from News n where title like :title and status like :status";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("title", "%" + findName + "%").setParameter("status","%"+ enable+"%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countNewsWhensearch(String enable,String name) {
		String jql="select n from News n where title like :title and status like :status ";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("title", "%" + name + "%").setParameter("status", "%"+ enable+"%");
		return (int) query.getResultList().size();
	}

	@Override
	public int countNewsOfCategory(String enable,int id) {
		String jql="select n from News n inner join NewCategory c on c.id=n.category.id where n.category.id=:id and n.status like :status";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("id",id).setParameter("status", "%"+ enable+"%");
		return (int) query.getResultList().size();
	}

	@Override
	public List<News> getAllNewsOfCat(String enable,int catId, int start, int length) {
		String jql="select n from News n where n.category.id=:catId and status like :status";
		Query query = entityManager.createQuery(jql,News.class);
		query.setParameter("catId",catId).setParameter("status", "%"+ enable+"%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	

	

}
