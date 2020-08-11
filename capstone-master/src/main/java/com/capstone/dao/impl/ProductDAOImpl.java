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
				+"where pr.resource.id = :resourceId";
		
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
	public List<Product> getAllProduct() {
		String jql = "select p from Product p";
		return entityManager.createQuery(jql,Product.class).getResultList();
	}
	@Override
	public Product getProductbyId(int id) {
		return entityManager.find(Product.class, id);
	
	}

}
