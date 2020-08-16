package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.dao.AppRoleDAO;
import com.capstone.entity.AppRole;
import com.capstone.entity.UserRole;

@Repository
@Transactional
public class AppRoleDAOImpl implements AppRoleDAO {
	
	@Autowired
    private EntityManager entityManager;
 
	@Override
    public List<String> getRoleNames(int userId) {
        String sql = "Select ur.appRole.roleName from " + UserRole.class.getName() + " ur " //
                + " where ur.appUser.userId = :userId ";
 
        Query query = this.entityManager.createQuery(sql, String.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

	@Override
	public List<AppRole> getAllAppRole() {
		String hql="select ar From AppRole ar where enable like '1' ";
		return entityManager.createQuery(hql,AppRole.class).getResultList();
	}
}
