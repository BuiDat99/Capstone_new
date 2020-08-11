package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.NewCategoryDAO;
import com.capstone.entity.NewCategory;

@Transactional
@Repository
public class NewCategoryDAOImpl implements NewCategoryDAO {

	@PersistenceContext
	
	EntityManager entityManager;
	@Override
	public void addCategory(NewCategory category) {
		entityManager.persist(category);
		
	}

	@Override
	public void updateCategory(NewCategory category) {
		entityManager.merge(category);
		
	}

	@Override
	public void deleteCategory(NewCategory category) {
		entityManager.remove(category);
		
	}

	@Override
	public List<NewCategory> getAllCategories() {
		String jql = "select nc from NewCategory nc";
		return entityManager.createQuery(jql,NewCategory.class).getResultList();
	}

	@Override
	public NewCategory getCategorybyId(int id) {
		return entityManager.find(NewCategory.class, id);
	}

	@Override
	public List<NewCategory> search(String findName, int start, int length) {
		String jql = "select nc from NewCategory nc where categoryName like :categoryName";
		Query query = entityManager.createQuery(jql,NewCategory.class);
		query.setParameter("categoryName", "%" + findName + "%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countCategoryWhensearch(String name) {
		String jql="select nc from NewCategory nc where categoryName like :categoryName";
		Query query = entityManager.createQuery(jql,NewCategory.class);
		query.setParameter("categoryName", "%" + name + "%");
		return (int) query.getResultList().size();
	}

}
