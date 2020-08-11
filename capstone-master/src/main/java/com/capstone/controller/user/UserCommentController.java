package com.capstone.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.CommentDTO;
import com.capstone.service.CommentService;

@Controller
public class UserCommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping(value = "/user/comment/add")
	public String AddCommentPost(HttpServletRequest request, @ModelAttribute(name = "addComment") CommentDTO comment,
			@RequestParam(value = "postId", required = false) int postId) {
		commentService.addComment(comment,postId);
		return "redirect:/detailNews?id="+postId;

	}
}
