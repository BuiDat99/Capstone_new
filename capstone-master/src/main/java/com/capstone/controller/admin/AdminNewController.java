package com.capstone.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.service.NewCategoryService;
import com.capstone.service.NewsService;

@Controller
public class AdminNewController {
	@Autowired
	private NewCategoryService categoryService;
	@Autowired
	private NewsService newsService;
	
	@GetMapping(value = "/admin/news/search")
	public String searchResource(HttpServletRequest request
//			,
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "page", required = false) Integer page
			) {
//		final int PAGE_SIZE = 7;
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword;
//		int totalPage = newsService.countNewsWhensearch(keyword);
//		int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
//		// mac dinh 10 ban ghi 1 trang
		List<NewsDTO> newsList = newsService.getAllNews();
		List<Integer> listCount = new ArrayList<Integer>();
//		for(int i=1;i<=pageCount;i++) {
//			listCount.add(i);
//		}
		request.setAttribute("newsList", newsList);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("listCount", listCount);
		return "admin/news/manage-news";
	}
	
	@GetMapping(value = "/admin/news/insert")
    public String NewsInsert(HttpServletRequest request, Model model) {
		model.addAttribute("news", new NewsDTO());
		List<NewCategoryDTO> list = categoryService.search("", 0, 100);
		request.setAttribute("categoryList", list);
        return "admin/news/add-news";
    }
	
	@PostMapping(value = "/admin/news/insert")
	public String AdminAddNewsPost(@ModelAttribute(name = "addCategory") NewsDTO news) {		
		newsService.addNews(news);
		return "redirect:/admin/news/search";

	}
	
	@GetMapping(value = "/admin/news/update")
	public String AdminUpdateNewGet(HttpServletRequest request,Model model, @RequestParam(name = "id") int id) {
		NewsDTO news = newsService.getNewsbyId(id);
		List<NewCategoryDTO> list = categoryService.search("", 0, 100);
		
		model.addAttribute("news", news);
		request.setAttribute("categoryList", list);
		return "admin/news/edit-news";
	}

	@PostMapping(value = "/admin/news/update")
	public String AdminUpdateNewsPost(@ModelAttribute(name = "category") NewsDTO news) {
		newsService.updateNews(news);
		return "redirect:/admin/news/search";
	}
			

	@GetMapping(value = "/admin/news/delete")
	public String deleteNews(int id) {
		newsService.deleteNews(id);
		return "redirect:/admin/news/search";
	}
}
