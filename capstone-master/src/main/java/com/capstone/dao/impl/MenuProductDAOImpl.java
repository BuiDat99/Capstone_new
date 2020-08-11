package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.MenuProductDAO;
import com.capstone.entity.MenuProduct;

@Transactional
@Repository
public class MenuProductDAOImpl implements MenuProductDAO {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void addMenuProduct(MenuProduct menuProduct) {
		entityManager.persist(menuProduct);
		
	}

	@Override
	public void updateMenuProduct(MenuProduct menuProduct) {
		entityManager.merge(menuProduct);
		
	}

	@Override
	public void deleteMenuProduct(MenuProduct menuProduct) {
		entityManager.remove(menuProduct);
		
	}

	@Override
	public List<MenuProduct> getAllMenuProduct() {
		String jql = "select mp from MenuProduct mp";
		return entityManager.createQuery(jql,MenuProduct.class).getResultList();
	}

	@Override
	public MenuProduct getMenuProductbyId(int id) {
		return entityManager.find(MenuProduct.class, id);
	}

}
