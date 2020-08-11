package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.HashtagDAO;
import com.capstone.entity.HashtagStandard;

@Transactional
@Repository
public class HashtagDAOImpl implements HashtagDAO {

	@PersistenceContext
	
	EntityManager entityManager;
	@Override
	public void addTag(HashtagStandard tag) {
		entityManager.persist(tag);
		
	}

	@Override
	public void updateTag(HashtagStandard tag) {
		entityManager.merge(tag);
		
	}

	@Override
	public void deleteTag(HashtagStandard tag) {
		entityManager.remove(tag);
		
	}

	@Override
	public List<HashtagStandard> getAllTags() {
		String jql = "select h from HashtagStandard h";
		return entityManager.createQuery(jql,HashtagStandard.class).getResultList();
	}
	
	@Override
	public HashtagStandard getTagbyId(int id) {
		
		return entityManager.find(HashtagStandard.class, id);
	}

	@Override
	public List<HashtagStandard> search(String findName, int start, int length) {
		String jql = "select h from HashtagStandard h where tagCode like :tagCode";
		Query query = entityManager.createQuery(jql,HashtagStandard.class);
		query.setParameter("tagCode", "%" + findName + "%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();			
	}

	@Override
	public int countTagWhensearch(String name) {
		String jql="select h from HashtagStandard h where tagCode like :tagCode";
		Query query = entityManager.createQuery(jql,HashtagStandard.class);
		query.setParameter("tagCode", "%" + name + "%");
		return (int) query.getResultList().size();
	}

	

}
