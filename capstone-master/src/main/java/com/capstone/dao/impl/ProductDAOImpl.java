package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.ProductDAO;
import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {


	@PersistenceContext
	
	EntityManager entityManager;
	@Override
	public List<String> getProductNameContainResource(int resourceId) {
		String sql = "Select pr.product.productName from" +ProductResource.class.getName()+ "pr"
				+"where pr.resource.id = :resourceId and ";
		
		Query query = this.entityManager.createQuery(sql,String.class);
		query.setParameter("resourceId", resourceId);
		return query.getResultList();
	}
	@Override
	public void addProduct(Product product) {
		entityManager.persist(product);
		
	}
	@Override
	public void updateProduct(Product product) {
		entityManager.merge(product);
		
	}
	@Override
	public void deleteProduct(Product product) {
		entityManager.remove(product);
		
	}
	@Override
	public List<Product> getAllProduct(String enable) {
		String jql = "select p from Product p where enable like :enable";
		return entityManager.createQuery(jql,Product.class).setParameter("enable", "%"+enable+"%").getResultList();
	}
	@Override
	public Product getProductbyId(int id) {
		return entityManager.find(Product.class, id);
	
	}
	@Override
	public List<Product> getAllProductByUser(String enable, int id) {
		String jql = "select p from Product p join p.user u where p.enable like :enable and u.userId =: id";
		return entityManager.createQuery(jql,Product.class).setParameter("enable", "%"+enable+"%").setParameter("id", id).getResultList();
	}
	@Override
	public List<Product> getTop4Products(String enable) {
		String jql = "select p from Product p where enable like :enable";
		return entityManager.createQuery(jql,Product.class).setParameter("enable", "%"+enable+"%").setMaxResults(4).getResultList();
	}
	@Override
	public List<Product> search(String enable, String findName, int start, int length) {
		String jql = "select p from Product p where productName like :productName and enable like :enable";
		Query query = entityManager.createQuery(jql,Product.class);
		query.setParameter("productName", "%" + findName + "%").setParameter("enable","%"+ enable+"%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}
	@Override
	public int countProductWhensearch(String enable, String name) {
		String jql="select p from Product p where productName like :productName and enable like :enable";
		Query query = entityManager.createQuery(jql,Product.class);
		query.setParameter("productName", "%" + name + "%").setParameter("enable", "%"+ enable+"%");
		return (int) query.getResultList().size();
	}

}
