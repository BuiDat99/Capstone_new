package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.capstone.dao.AppUserDAO;
import com.capstone.dao.CommentDAO;
import com.capstone.dao.NewsDAO;
import com.capstone.entity.AppUser;
import com.capstone.entity.Comment;
import com.capstone.entity.News;
import com.capstone.model.AppUserDTO;
import com.capstone.model.CommentDTO;
import com.capstone.model.NewsDTO;
import com.capstone.service.CommentService;

@Service
@Repository
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	@Autowired
	private AppUserDAO userDao;
	@Autowired
	private NewsDAO newsDao;
	@Override
	public void addComment(CommentDTO comment, int postId) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Comment m = new Comment();
		m.setComment_Content(comment.getCommentContent());
		m.setComment_Date(comment.getCommentDate());
		m.setReact(comment.getReact());
		m.setVote(comment.getVote());
		m.setEnable("1");
		AppUser u = userDao.findAppUserbyUserName(username);
		m.setAppUser(u);
		
		News n = newsDao.getNewsbyId(postId);
		m.setNews(n);
		
		commentDAO.addComment(m);
		comment.setId(m.getId());
		
	}

	@Override
	public void updateComment(CommentDTO comment) {
		Comment m = commentDAO.getCommentbyId(comment.getId());
		if(m != null) {
			m.setComment_Content(comment.getCommentContent());
			m.setComment_Date(comment.getCommentDate());
			m.setReact(comment.getReact());
			m.setVote(comment.getVote());
			m.setEnable(comment.getEnable());
			commentDAO.updateComment(m);
		}
		
		
	}

	@Override
	public void deleteComment(int id) {
		Comment m = commentDAO.getCommentbyId(id);
		if(m != null) {
			commentDAO.deleteComment(m);
		}
		
	}

	@Override
	public List<CommentDTO> getAllComment() {
		List<Comment> ms = commentDAO.getAllComment();
		List<CommentDTO> dtos = new ArrayList<CommentDTO>();
		for(Comment m: ms) {
			CommentDTO dto = new CommentDTO();
			dto.setId(m.getId());
			dto.setCommentContent(m.getComment_Content());
			dto.setCommentDate(m.getComment_Date());
			dto.setReact(m.getReact());
			dto.setVote(m.getVote());
			dto.setEnable(m.getEnable());
			AppUserDTO u = new AppUserDTO();
			u.setUsername(m.getAppUser().getUserName());
			u.setAvata(m.getAppUser().getImage());
			dto.setUser(u);
			
			NewsDTO n = new NewsDTO();
			n.setTitle(m.getNews().getTitle());
			dto.setNews(n);
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public CommentDTO getCommentbyId(int id) {
		Comment m = commentDAO.getCommentbyId(id);
		CommentDTO dto = new CommentDTO();
		dto.setId(m.getId());
		dto.setCommentContent(m.getComment_Content());
		dto.setCommentDate(m.getComment_Date());
		dto.setReact(m.getReact());
		dto.setVote(m.getVote());
		dto.setEnable(m.getEnable());
		
		return dto;
		
	}

	@Override
	public List<CommentDTO> getComentbyPostId(String enable,int postId, int start, int length) {
		List<Comment> ms = commentDAO.getComentbyPostId(enable,postId, start, length);
		List<CommentDTO> dtos = new ArrayList<CommentDTO>();
		for(Comment m: ms) {
			CommentDTO dto = new CommentDTO();
			dto.setId(m.getId());
			dto.setCommentContent(m.getComment_Content());
			dto.setCommentDate(m.getComment_Date());
			dto.setReact(m.getReact());
			dto.setVote(m.getVote());
			dto.setEnable(m.getEnable());
			AppUserDTO u = new AppUserDTO();
			u.setUsername(m.getAppUser().getUserName());
			u.setAvata(m.getAppUser().getImage());
			dto.setUser(u);
			
			NewsDTO n = new NewsDTO();
			n.setTitle(m.getNews().getTitle());
			dto.setNews(n);
			
			dtos.add(dto);
		}
		
		return dtos;
	}

	@Override
	public int countCommentOfPost(int id) {
		return commentDAO.countCommentOfPost(id);
	}

}
