package com.capstone.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.AppUserDTO;
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
	@GetMapping(value = "/admin/comment/mokhoa")
	public String AdminmokhoaUserGet(@RequestParam (name="id") int id) {
		CommentDTO appUserDTO= commentService.getCommentbyId(id);
		appUserDTO.setEnable("1");
		commentService.updateComment(appUserDTO);
		return "redirect:/admin/comment/search";
	}
	@GetMapping(value = "/admin/comment/khoa")
	public String AdminkhoaUserGet(@RequestParam (name="id") int id) {
		CommentDTO appUserDTO= commentService.getCommentbyId(id);
		appUserDTO.setEnable("0");
		commentService.updateComment(appUserDTO);
		return "redirect:/admin/comment/search";
	}
}
