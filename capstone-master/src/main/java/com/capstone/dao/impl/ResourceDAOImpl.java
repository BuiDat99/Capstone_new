package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.ResourceDAO;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;

@Transactional
@Repository
public class ResourceDAOImpl implements ResourceDAO {

	@PersistenceContext
	
	EntityManager entityManager;
	
	@Override
	public List<Resource> getResourceOfProduct(int productId) {
		String sql = "Select pr.resource.resourceName from" +ProductResource.class.getName()+ "pr"
				+"where pr.product.id = :productId";
		
		Query query = this.entityManager.createQuery(sql,Resource.class);
		query.setParameter("productId", productId);
		return query.getResultList();
	}
	
	@Override
	public void addResource(Resource resource) {
		entityManager.persist(resource);
		
	}

	@Override
	public void updateResource(Resource resource) {
		entityManager.merge(resource);
		
	}

	@Override
	public void deleteResource(Resource resource) {
		entityManager.remove(resource);
		
	}

	@Override
	public List<Resource> getAllResources(String a) {
		String jql = "select r from Resource r where enable like :e";
		return entityManager.createQuery(jql,Resource.class).setParameter("e", "%"+a+"%").getResultList();
	}

	@Override
	public Resource getResourcebyId(int id) {
		return entityManager.find(Resource.class, id);
	}

	@Override
	public List<Resource> search(String a,String findName, int start, int length) {
		String jql = "select r from Resource r where resourceName like :resourceName and enable like :c";
		Query query = entityManager.createQuery(jql,Resource.class);
		query.setParameter("resourceName", "%" + findName + "%").setParameter("c", "%"+a+"%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countResourceWhensearch(String a,String name) {
		String jql="select r from Resource r where resourceName like :resourceName and enable like :c";
		Query query = entityManager.createQuery(jql,Resource.class);
		query.setParameter("resourceName", "%" + name + "%").setParameter("c", "%"+a+"%");
		return (int) query.getResultList().size();
	}

	@Override
	public List<Resource> getResourceByCategory(String a,String catName) {
		String jql="select r from Resource r inner join ResourceCategory c on c.id=r.category.id where c.categoryName=:catName and r.enable like :c";
		Query query = entityManager.createQuery(jql,Resource.class);
		query.setParameter("catName",catName);
		return query.getResultList();
	}

	
	@Override
	public List<Resource> getResourceFromWithResouceCatId(int categoryId) {
		String jql = "select r from Resource r where category_id = :categoryId";
		Query query = entityManager.createQuery(jql,Resource.class);
		query.setParameter("categoryId", categoryId);
		return query.getResultList();
	}
}
