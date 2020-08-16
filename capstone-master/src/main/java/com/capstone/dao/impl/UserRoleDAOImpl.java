package com.capstone.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capstone.dao.UserRoleDAO;
import com.capstone.entity.UserRole;

@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void deleteUserRole(UserRole userRole) {
		entityManager.remove(userRole);
		
	}
}
