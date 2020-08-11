package com.capstone.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.CommentDTO;
import com.capstone.model.HashTagDTO;
import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.service.CommentService;
import com.capstone.service.HashTagService;
import com.capstone.service.NewCategoryService;
import com.capstone.service.NewsService;

@Controller
public class UserController {

	@Autowired
	private NewsService newsService;
	@Autowired
	private NewCategoryService newCatService;
	@Autowired		
	private HashTagService hashtagService;
	@Autowired
	private CommentService commentService;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		List<NewsDTO> listNews = newsService.getTop6News();
		request.setAttribute("NewList", listNews);
		return "/user/home";
	}
	
	@RequestMapping(value = "/tintuc", method = RequestMethod.GET)
	public String Tintuc(HttpServletRequest request, @RequestParam(name = "catId") Optional<Integer> catId,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page) {
//		NewCategoryDTO category = new NewCategoryDTO();				
		if(!catId.isPresent()) {
			final int PAGE_SIZE = 1;
			page = page == null ? 1 : page;
			keyword = keyword == null ? "" : keyword;
			int totalPage = newsService.countNewsWhensearch(keyword);
			int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
		List<NewsDTO> listNews = newsService.search(keyword, (page-1) * PAGE_SIZE, PAGE_SIZE);
		List<Integer> listCount = new ArrayList<Integer>();
		for(int i=1;i<=pageCount;i++) {
		listCount.add(i);
		}
		request.setAttribute("NewList", listNews);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		request.setAttribute("listCount", listCount);
		} else {
			final int PAGE_SIZE = 1;
			page = page == null ? 1 : page;
			keyword = keyword == null ? "" : keyword;
			int totalPage = newsService.countNewsOfCategory(catId.get());
			int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
			List<NewsDTO> listNews = newsService.getAllNewsOfCat(catId.get(),(page-1) * PAGE_SIZE, PAGE_SIZE);
			List<Integer> listCount = new ArrayList<Integer>();
			for(int i=1;i<=pageCount;i++) {
				listCount.add(i);
				}
			request.setAttribute("NewList", listNews);
			request.setAttribute("page", page);
			request.setAttribute("keyword", keyword);
			request.setAttribute("listCount", listCount);
		}	
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories();
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate();
		List<HashTagDTO> listTag = hashtagService.getAllTags();
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat =0;			
			countCat = newsService.countNewsOfCategory(newCate.getId());
			String count = "("+countCat+")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);		
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		
		return "/user/all_news";
	}
	
	
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	public String ChangePassGet(HttpServletRequest request, Principal principal) {	
		
		return "/user/changedPassword";
	}
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_USER')")
	public String changeUserPassword(HttpServletRequest request,final Locale locale,
			@RequestParam(value = "oldPassword", required = false) String oldPassword,
			@RequestParam(value = "newPassword", required = false) String newPass) {	
		
		System.out.print(oldPassword);
		System.out.print(newPass);
		
//		AppUser user = userService.findUserByEmail(
//			      SecurityContextHolder.getContext().getAuthentication().getName());
//	    
//	    if (!userService.checkIfValidOldPassword(user, oldPassword)) {
//	        throw new InvalidOldPasswordException();
//	    }
//	    userService.changeUserPassword(user, newPass);
	    return null;
	}

	
	@RequestMapping(value = "/detailNews", method = RequestMethod.GET)
	public String DetailNew(HttpServletRequest request,Model model, @RequestParam(name = "id") int id) {	
//		NewCategoryDTO category = new NewCategoryDTO();
		NewsDTO news = newsService.getNewsbyId(id);
		NewCategoryDTO newCat =newCatService.getCategorybyId(id);
		int countCom = commentService.countCommentOfPost(id);
		List<CommentDTO> comment = commentService.getComentbyPostId(id, 0, 100);
		String catName = newCat.getCategoryName();
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories();
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate();
		List<HashTagDTO> listTag = hashtagService.getAllTags();
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat =0;			
			countCat = newsService.countNewsOfCategory(newCate.getId());
			String count = "("+countCat+")";
			newCate.setCount(count);
		}
		model.addAttribute("news", news);
		request.setAttribute("countCom", countCom);
		request.setAttribute("comment", comment);
		request.setAttribute("catName", catName);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		return "/user/detailNews";
		
	}
	
	
}
