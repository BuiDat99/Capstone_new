package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.CommentDAO;
import com.capstone.entity.Comment;

@Transactional
@Repository
public class CommentDAOImpl implements CommentDAO{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void addComment(Comment comment) {
		entityManager.persist(comment);
		
	}

	@Override
	public void updateComment(Comment comment) {
		entityManager.merge(comment);
		
	}

	@Override
	public void deleteComment(Comment comment) {
		entityManager.remove(comment);
		
	}

	@Override
	public List<Comment> getAllComment() {
		String jql = "select c from Comment c";
		return entityManager.createQuery(jql,Comment.class).getResultList();
	}

	@Override
	public Comment getCommentbyId(int id) {
		return entityManager.find(Comment.class, id);
	}

	@Override
	public List<Comment> getComentbyPostId(int postId, int start, int length) {
		String jql="select m from Comment m where m.news.id=:postId";
		Query query = entityManager.createQuery(jql,Comment.class);
		query.setParameter("postId",postId);
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countCommentOfPost(int id) {
		String jql="select m from Comment m where m.news.id=:postId";
		Query query = entityManager.createQuery(jql,Comment.class);
		query.setParameter("postId",id);
		return (int) query.getResultList().size();
	}

}
