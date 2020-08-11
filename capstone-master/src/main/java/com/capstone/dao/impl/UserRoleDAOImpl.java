package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.UserRoleDAO;
import com.capstone.entity.UserRole;

@Repository
@Transactional
public class UserRoleDAOImpl implements UserRoleDAO {

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void addUserRole(UserRole userRole) {
		entityManager.persist(userRole);
		
	}

	@Override
	public void updateUserRole(UserRole userRole) {
		entityManager.merge(userRole);
		
	}

	@Override
	public void deleteUserRole(UserRole userRole) {
		entityManager.remove(userRole);
		
	}

	@Override
	public List<UserRole> getAllUserRole() {
		String jql = "select ur from UserRole ur";
		return entityManager.createQuery(jql,UserRole.class).getResultList();
	}

	@Override
	public UserRole getUserRolebyId(int id) {
		return entityManager.find(UserRole.class, id);
	}
}
