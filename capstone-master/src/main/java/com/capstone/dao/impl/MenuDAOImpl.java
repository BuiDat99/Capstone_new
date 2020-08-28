package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public List<Menu> getAllMenu(String hashtag, String enable) {
		String jql = "select m from Menu m where enable like :enable and hashtag like :h";
		return entityManager.createQuery(jql, Menu.class).setParameter("enable", "%" + enable + "%")
				.setParameter("h", "%" + hashtag + "%").getResultList();
	}

	@Override
	public Menu getMenubyId(int id) {
		return entityManager.find(Menu.class, id);
	}

	@Override
	public List<Menu> getAllMenubyUserId(String enable, String hashtag, int userId) {
		String jql = "select m from Menu m join m.user u where m.enable like :enable and m.hashtag like :h and u.userId =:uId ";
		return entityManager.createQuery(jql, Menu.class).setParameter("enable", "%" + enable + "%")
				.setParameter("h", "%" + hashtag + "%").setParameter("uId", userId).getResultList();
	}
	@Override
	public List<Menu> search(String hash, String enable, String findName, int start, int length) {
		String jql = "select m from Menu m where menuName like :menuName and enable like :enable and hashtag like :s";
		Query query = entityManager.createQuery(jql,Menu.class);
		query.setParameter("menuName", "%" + findName + "%").setParameter("enable","%"+ enable+"%").setParameter("s","%"+ hash+"%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countMenuWhensearch(String h, String enable, String name) {
		String jql="select m from Menu m where menuName like :menuName and enable like :enable and hashtag like :s ";
		Query query = entityManager.createQuery(jql,Menu.class);
		query.setParameter("menuName", "%" + name + "%").setParameter("enable", "%"+ enable+"%").setParameter("s", "%"+ h+"%");
		return (int) query.getResultList().size();
	}

}
