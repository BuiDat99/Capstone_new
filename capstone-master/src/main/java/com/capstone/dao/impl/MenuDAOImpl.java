package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.MenuDAO;
import com.capstone.entity.Menu;

@Transactional
@Repository
public class MenuDAOImpl implements MenuDAO {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void addMenu(Menu menu) {
		entityManager.persist(menu);
		
	}

	@Override
	public void updateMenu(Menu menu) {
		entityManager.merge(menu);
		
	}

	@Override
	public void deleteMenu(Menu menu) {
		entityManager.remove(menu);
		
	}

	@Override
	public List<Menu> getAllMenu(String hashtag,String enable ) {
		String jql = "select m from Menu m where enable like :enable and hashtag like :h";
		return entityManager.createQuery(jql,Menu.class).setParameter("enable", "%"+enable+"%").setParameter("h", "%"+hashtag+"%").getResultList();
	}

	@Override
	public Menu getMenubyId(int id) {
		return entityManager.find(Menu.class, id);
	}

}
