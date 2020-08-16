package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;

@Repository
@Transactional
public class AppUserDAOImpl implements AppUserDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public AppUser findUserAccount(String userName) { // Hoan thien function nay de check exist User
		try {
			String sql = "Select e from " + AppUser.class.getName() + " e " //
					+ " Where e.userName = :userName ";
			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("userName", userName);
			return (AppUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public AppUser findUserAccountEmail(String email) { // Hoan thien function nay de check exist Email
		try {
			String sql = "Select e from " + AppUser.class.getName() + " e " //
					+ " Where e.email = :email ";
			Query query = entityManager.createQuery(sql, AppUser.class);
			query.setParameter("email", email);
			return (AppUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	// search account exist or no
	@Override
	public AppUser findAppUserbyUserName(String username) { // them function nay nhung khong dung den
		String jql = "select u from AppUser u where userName = :name";
		Query query = entityManager.createQuery(jql, AppUser.class);
		query.setParameter("name", username);
		return (AppUser) query.getSingleResult();
	}

	@Override
	public void insert(AppUser user) {
		entityManager.persist(user);
	}

	@Override
	public void update(AppUser user) {
		entityManager.merge(user);
	}

	@Override
	public void delete(AppUser user) {
		entityManager.remove(user);
	}

	@Override
	public AppUser get(int id) {
		return entityManager.find(AppUser.class, id);
	}

	@Override
	public List<AppUser> search(String findName, int start, int length) {
		String jql = "select u from AppUser u where User_Name like :name";
		Query query = entityManager.createQuery(jql, AppUser.class);
		query.setParameter("name", "%" + findName + "%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public List<AppUser> getAllUser() {
		String jql = "select u from AppUser u";
		return entityManager.createQuery(jql, AppUser.class).getResultList();
	}

}