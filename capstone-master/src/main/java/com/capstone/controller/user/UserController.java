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
import com.capstone.model.MenuDTO;
import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.model.ProductDTO;
import com.capstone.service.CommentService;
import com.capstone.service.HashTagService;
import com.capstone.service.MenuService;
import com.capstone.service.NewCategoryService;
import com.capstone.service.NewsService;
import com.capstone.service.ProductService;

@Controller
public class UserController {

	@Autowired
	private NewsService newsService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private NewCategoryService newCatService;
	@Autowired		
	private HashTagService hashtagService;
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		List<NewsDTO> listNews = newsService.getTop6News("1");
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
			int totalPage = newsService.countNewsWhensearch("1",keyword);
			int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
		List<NewsDTO> listNews = newsService.search("1",keyword, (page-1) * PAGE_SIZE, PAGE_SIZE);
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
			int totalPage = newsService.countNewsOfCategory("1",catId.get());
			int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
			List<NewsDTO> listNews = newsService.getAllNewsOfCat("1",catId.get(),(page-1) * PAGE_SIZE, PAGE_SIZE);
			List<Integer> listCount = new ArrayList<Integer>();
			for(int i=1;i<=pageCount;i++) {
				listCount.add(i);
				}
			request.setAttribute("NewList", listNews);
			request.setAttribute("page", page);
			request.setAttribute("keyword", keyword);
			request.setAttribute("listCount", listCount);
		}	
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat =0;			
			countCat = newsService.countNewsOfCategory("1",newCate.getId());
			String count = "("+countCat+")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);		
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		
		return "/user/all_news";
	}
	
	
//	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
//	public String ChangePassGet(HttpServletRequest request, Principal principal) {	
//		
//		return "/user/changedPassword";
//	}
//	@RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
//	@PreAuthorize("hasRole('ROLE_USER')")
//	public String changeUserPassword(HttpServletRequest request,final Locale locale,
//			@RequestParam(value = "oldPassword", required = false) String oldPassword,
//			@RequestParam(value = "newPassword", required = false) String newPass) {	
//		
//		System.out.print(oldPassword);
//		System.out.print(newPass);
//		
////		AppUser user = userService.findUserByEmail(
////			      SecurityContextHolder.getContext().getAuthentication().getName());
////	    
////	    if (!userService.checkIfValidOldPassword(user, oldPassword)) {
////	        throw new InvalidOldPasswordException();
////	    }
////	    userService.changeUserPassword(user, newPass);
//	    return null;
//	}

	
	@RequestMapping(value = "/detailNews", method = RequestMethod.GET)
	public String DetailNew(HttpServletRequest request,Model model, @RequestParam(name = "id") int id) {	
//		NewCategoryDTO category = new NewCategoryDTO();
		NewsDTO news = newsService.getNewsbyId(id);
		NewCategoryDTO newCat =newCatService.getCategorybyId(id);
		int countCom = commentService.countCommentOfPost(id);
		List<CommentDTO> comment = commentService.getComentbyPostId("1",id, 0, 100);
		String catName = newCat.getCategoryName();
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat =0;			
			countCat = newsService.countNewsOfCategory("1",newCate.getId());
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
	
	@RequestMapping(value = "/mon_an", method = RequestMethod.GET)
	public String Monan(HttpServletRequest request,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page) {
//		
		
		List<ProductDTO> productDTOs= productService.getAllProducts("1");
		for(ProductDTO dto:productDTOs) {
			System.out.println(dto.getId());
		}
		request.setAttribute("productDTOs", productDTOs);
		
		return "/user/all_foods";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String Menu(HttpServletRequest request,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page) {
//		
		
		List<MenuDTO> menuDTOs= menuService.getAllMenu("1");
		
		request.setAttribute("menuDTOs", menuDTOs);
		
		return "/user/all-menu";
	}
	
}
