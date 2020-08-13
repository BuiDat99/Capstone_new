package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.ResourceCategoryDAO;
import com.capstone.entity.ResourceCategory;

@Transactional
@Repository
public class ResourceCategoryDAOImpl implements ResourceCategoryDAO {

	@PersistenceContext
	
	EntityManager entityManager;
	@Override
	public void addCategory(ResourceCategory category) {
		entityManager.persist(category);
		
	}

	@Override
	public void updateCategory(ResourceCategory category) {
		entityManager.merge(category);
		
	}

	@Override
	public void deleteCategory(ResourceCategory category) {
		entityManager.remove(category);
		
	}

	@Override
	public List<ResourceCategory> getAllCategories(String c) {
		String jql = "select rc from ResourceCategory rc where enable like :c";
		return entityManager.createQuery(jql,ResourceCategory.class).setParameter("c", "%"+c+"%").getResultList();
	}

	@Override
	public ResourceCategory getCategorybyId(int id) {
		return entityManager.find(ResourceCategory.class, id);
	}

	@Override
	public List<ResourceCategory> search(String c,String findName, int start, int length) {
		String jql = "select rc from ResourceCategory rc where categoryName like :categoryName and enable like :c";
		Query query = entityManager.createQuery(jql,ResourceCategory.class);
		query.setParameter("categoryName", "%" + findName + "%").setParameter("c", "%"+c+"%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countCategoryWhensearch(String c,String name) {
		String jql="select rc from ResourceCategory rc where categoryName like :categoryName and enable like :c";
		Query query = entityManager.createQuery(jql,ResourceCategory.class);
		query.setParameter("categoryName", "%" + name + "%").setParameter("c", "%"+c+"%");
		return (int) query.getResultList().size();
	}

}
