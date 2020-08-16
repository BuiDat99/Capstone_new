package com.capstone.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capstone.entity.UserHistory;

public interface UserHistoryDao {
	void add(UserHistory userHistory);
	void update(UserHistory userHistory);
	void delete(UserHistory userHistory);
	UserHistory getUserHistory(int id);
	List<UserHistory> searchUserHistory(int id);
	
}
@Transactional
@Repository
class UserHistoryDaoImpl implements UserHistoryDao{
	@Autowired
	EntityManager entityManager;
	@Override
	public void add(UserHistory userHistory) {
		entityManager.persist(userHistory);
	}

	@Override
	public void update(UserHistory userHistory) {
		entityManager.merge(userHistory);
	}

	@Override
	public void delete(UserHistory userHistory) {
		entityManager.remove(userHistory);
	}

	@Override
	public UserHistory getUserHistory(int id) {
		return entityManager.find(UserHistory.class, id);
	}

	@Override
	public List<UserHistory> searchUserHistory(int id) {
		String hql="select uh from UserHistory uh join uh.appUser a  where a.userId =:id";
		return entityManager.createQuery(hql,UserHistory.class).setParameter("id", id).getResultList();
	}
	
}