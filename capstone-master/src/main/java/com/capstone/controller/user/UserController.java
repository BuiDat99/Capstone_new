package com.capstone.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;
import com.capstone.model.AppUserDTO;
import com.capstone.model.CommentDTO;
import com.capstone.model.HashTagDTO;
import com.capstone.model.MenuDTO;
import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.UserHistoryDTO;
import com.capstone.service.AppUserService;
import com.capstone.service.CommentService;
import com.capstone.service.HashTagService;
import com.capstone.service.MenuService;
import com.capstone.service.NewCategoryService;
import com.capstone.service.NewsService;
import com.capstone.service.ProductResourceService;
import com.capstone.service.ProductService;
import com.capstone.service.UserHistoryService;

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
	private UserHistoryService historyService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductResourceService productResourceService;
	
	@Autowired
	private AppUserDAO appUserDAO;
	@Autowired
	private AppUserService appUserService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request,HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		List<NewsDTO> listNews = newsService.getTop6News("1");
		request.setAttribute("NewList", listNews);
		
		List<ProductDTO> listProducts = productService.getTop4Products("1");
		request.setAttribute("ProductList", listProducts);
		return "/user/home";
	}

	@RequestMapping(value = "/tintuc", method = RequestMethod.GET)
	public String Tintuc(HttpServletRequest request, @RequestParam(name = "catId", required = false) String catId,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page,HttpSession httpSession) {
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		keyword = keyword == null ? "" : keyword;
		catId = catId == null ? "" : catId;
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
//		NewCategoryDTO category = new NewCategoryDTO();				
		if (catId=="") {
			final int PAGE_SIZE = 3;
			page = page == null ? 1 : page;			
			int totalPage = newsService.countNewsWhensearch(has, "1", keyword);
			int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
			List<NewsDTO> listNews = newsService.search(has, "1", keyword, (page - 1) * PAGE_SIZE, PAGE_SIZE);
			List<Integer> listCount = new ArrayList<Integer>();
			for (int i = 1; i <= pageCount; i++) {
				listCount.add(i);
			}
			request.setAttribute("NewList", listNews);
			request.setAttribute("page", page);
			request.setAttribute("keyword", keyword);
			request.setAttribute("listCount", listCount);
			request.setAttribute("hashtag", has);
//			request.setAttribute("catId", catId);
		} else {
			final int PAGE_SIZE = 3;
			page = page == null ? 1 : page;
			int totalPage = newsService.countNewsOfCategory(has, "1", Integer.parseInt(catId));
			int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
			List<NewsDTO> listNews = newsService.getAllNewsOfCat("1", Integer.parseInt(catId), (page - 1) * PAGE_SIZE, PAGE_SIZE);
			List<Integer> listCount = new ArrayList<Integer>();
			for (int i = 1; i <= pageCount; i++) {
				listCount.add(i);
			}
			request.setAttribute("NewList", listNews);
			request.setAttribute("page", page);
			request.setAttribute("keyword", keyword);
			request.setAttribute("listCount", listCount);
			request.setAttribute("hashtag", has);
		}
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		request.setAttribute("catId", catId);

		return "/user/all_news";
	}

	@RequestMapping(value = "/detailNews", method = RequestMethod.GET)
	public String DetailNew(HttpServletRequest request, Model model, @RequestParam(name = "id") int id,HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
//		NewCategoryDTO category = new NewCategoryDTO();
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		NewsDTO news = newsService.getNewsbyId(id);
		//NewCategoryDTO newCat = newCatService.getCategorybyId(id);
		int countCom = commentService.countCommentOfPost(id);
		List<CommentDTO> comment = commentService.getComentbyPostId("1", id, 0, 100);
		//String catName = newCat.getCategoryName();
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
		model.addAttribute("news", news);
		request.setAttribute("countCom", countCom);
		request.setAttribute("comment", comment);
		//request.setAttribute("catName", catName);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		return "/user/detailNews";

	}
	
	@RequestMapping(value = "/detailProduct", method = RequestMethod.GET)
	public String DetailProduct(HttpServletRequest request, Model model, @RequestParam(name = "Pid") int id,HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
//		NewCategoryDTO category = new NewCategoryDTO();
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		ProductDTO products = productService.getProductbyId(id);
		NewCategoryDTO newCat = newCatService.getCategorybyId(id);
		int countCom = commentService.countCommentOfPost(id);
		List<CommentDTO> comment = commentService.getComentbyPostId("1", id, 0, 100);
		String catName = newCat.getCategoryName();
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
		model.addAttribute("products", products);
		request.setAttribute("products", products);
		request.setAttribute("countCom", countCom);
		request.setAttribute("comment", comment);
		request.setAttribute("catName", catName);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		return "/user/detailProducts";

	}

	@RequestMapping(value = "/mon_an", method = RequestMethod.GET)
	public String Monan(HttpServletRequest request, @RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page,HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}

		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		final int PAGE_SIZE = 3;
		page = page == null ? 1 : page;
		keyword = keyword == null ? "" : keyword;
		int totalPage = productService.countProductWhensearch("1", keyword);
		int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
		List<ProductDTO> listProducts = productService.search("1", keyword, (page - 1) * PAGE_SIZE, PAGE_SIZE);
		List<Integer> listCount = new ArrayList<Integer>();
		for (int i = 1; i <= pageCount; i++) {
			listCount.add(i);
		}
		request.setAttribute("listProducts", listProducts);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		request.setAttribute("listCount", listCount);		
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);

		return "/user/edit/all_food";
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String Thucdon(HttpServletRequest request, @RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page, HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		final int PAGE_SIZE = 4;
		page = page == null ? 1 : page;
		keyword = keyword == null ? "" : keyword;
		int totalPage = menuService.countMenuWhensearch(has, "1", keyword);
		int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
		List<MenuDTO> listMenu = menuService.search(has, "1", keyword,  (page - 1) * PAGE_SIZE, PAGE_SIZE);
		List<Integer> listCount = new ArrayList<Integer>();
		for (int i = 1; i <= pageCount; i++) {
			listCount.add(i);
		}
		request.setAttribute("listMenu", listMenu);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		request.setAttribute("listCount", listCount);
		request.setAttribute("hashtag", has);
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);

		return "/user/edit/all_menu";
	}
	
	@RequestMapping(value = "/detailMenu", method = RequestMethod.GET)
	public String detailMenu(HttpServletRequest request, Model model, @RequestParam(name = "Mid") int id,HttpSession httpSession) {
//		NewCategoryDTO category = new NewCategoryDTO();
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		MenuDTO menu = menuService.getMenubyId(id);
		System.out.println(menu.getMenuName());
		model.addAttribute("menu", menu);
		
		request.setAttribute("hashtag", has);
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories("1");
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate("1");
		List<HashTagDTO> listTag = hashtagService.getAllTags("1");
		for (NewCategoryDTO newCate : listNewsCat) {
			int countCat = 0;
			countCat = newsService.countNewsOfCategory(has, "1", newCate.getId());
			String count = "(" + countCat + ")";
			newCate.setCount(count);
		}
//		int countCat = newsService.countNewsOfCategory(1);
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
		return "/user/detailMenu";

	}
	@RequestMapping(value = "/user/history", method = RequestMethod.GET)
	public String history(HttpServletRequest request, Principal principal,Model model,HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user= appUserDAO.findAppUserbyUserName(loginedUser.getUsername());
		AppUserDTO appUserDTO= appUserService.get(user.getUserId());
		List<UserHistoryDTO> historyDTOs= historyService.searchUserHistory(appUserDTO.getUserId());
		request.setAttribute("historyDTOs", historyDTOs);
		return "/user/profile";
	}
	@RequestMapping(value = "/news_and_menu", method = RequestMethod.GET)
	public String MenuandNews(HttpServletRequest request, @RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page, HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");

		List<MenuDTO> menuDTOs = menuService.getAllMenu(has, "1");
		List<NewsDTO> listNews = newsService.search(has, "1","",0,1000);
		request.setAttribute("menuDTOs", menuDTOs);
		request.setAttribute("listNews", listNews);
		request.setAttribute("hash", has);

		return "/user/newsandmenu";
	}
}
