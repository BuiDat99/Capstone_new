package com.capstone.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.capstone.model.CommentDTO;
import com.capstone.service.CommentService;

@Controller
public class AdminCommentController {

	@Autowired
	private CommentService commentService;
	@GetMapping(value = "/admin/comment/search")
	public String searchComment(HttpServletRequest request) {
		List<CommentDTO> comList = commentService.getAllComment();
		request.setAttribute("comList", comList);
		return "admin/comment/manage-comment";
	}
}
