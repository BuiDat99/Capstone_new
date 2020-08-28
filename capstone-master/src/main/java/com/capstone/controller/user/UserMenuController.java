package com.capstone.controller.user;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;
import com.capstone.model.HashTagDTO;
import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.model.ProductDTO;
import com.capstone.service.HashTagService;
import com.capstone.service.MenuProductService;
import com.capstone.service.MenuService;
import com.capstone.service.NewCategoryService;
import com.capstone.service.NewsService;
import com.capstone.service.ProductService;

@Controller
public class UserMenuController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private AppUserDAO appUserService;

	@Autowired
	private MenuProductService mpService;

	@Autowired
	private ProductService productService;

	@Autowired
	private NewsService newsService;
	
	@Autowired
	private HashTagService hashtagService;
	
	@Autowired
	private NewCategoryService newCatService;
	@GetMapping(value = "/user/menu/add-menu")
	public String addMenuGet(HttpServletRequest request) {
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		
		List<ProductDTO> productDTOs = productService.getAllProducts("1");
		request.setAttribute("listProduct", productDTOs);
		
		// filter

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
		return "user/edit/add_menu";
	}

	@PostMapping(value = "/user/menu/add-menu")
	@ResponseBody
	public MenuDTO addMenuPost(HttpServletRequest request, @RequestBody MenuDTO menuDTO, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserService.findAppUserbyUserName(loginedUser.getUsername());
		MenuDTO dto = menuDTO;
		dto.setUserId(user.getUserId());
		menuService.addMenu(dto);
		for (String string : menuDTO.getListproductId()) {
			System.out.println(string);
			MenuProductDTO menuProductDTO = new MenuProductDTO();
			ProductDTO productDTO = productService.getProductbyId(Integer.parseInt(string));
			menuProductDTO.setMenu(dto);
			menuProductDTO.setProduct(productDTO);
			mpService.addMenuProduct(menuProductDTO);
		}
		return menuDTO;
	}

	@GetMapping(value = "/user/product")
	public @ResponseBody List<ProductDTO> getAllProducts() {
		return productService.getAllProducts("1");
	}
	
	@GetMapping(value = "/user/menu/edit-menu")
	public String updateMenuGet(HttpServletRequest request, @RequestParam(name = "id") int id, Model model) {
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		
		MenuDTO menuDTO = menuService.getMenubyId(id);
		model.addAttribute("menuDTO", menuDTO);
		
		// filter

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
		return "user/edit/edit_menu";
	}

	@PostMapping(value = "/user/menu/edit-menu")
	@ResponseBody
	public MenuDTO updateMenuPost(HttpServletRequest request, @RequestBody MenuDTO menuDTO) {		
		MenuDTO menuDTO2 = menuService.getMenubyId(menuDTO.getId());

		menuDTO.setEnable("1");
		menuService.updateMenu(menuDTO);

		for (String string : menuDTO.getListproductId()) {

			ProductDTO productDTO = productService.getProductbyId(Integer.parseInt(string));
			MenuProductDTO menuProductDTO = new MenuProductDTO();
			menuProductDTO.setProduct(productDTO);
			menuProductDTO.setMenu(menuDTO);
			mpService.addMenuProduct(menuProductDTO);
			System.out.println("them " + menuProductDTO.getId());
		}
		for (MenuProductDTO menuProductDTO : menuDTO2.getMenuProductDTOs()) {
			mpService.deleteMenuProduct(menuProductDTO.getId());
		}
		return menuDTO;
	}

	

	@GetMapping(value = "/user/menu/delete-menu")
	public String deleteMenuGet(HttpServletRequest request, @RequestParam(name = "id") int id) {
		menuService.deleteMenu(id);
		return "redirect:/user/menu/search";
	}

	@GetMapping(value = "/user/menu/search")
	public String searchMenu(HttpServletRequest request,Principal principal) {
		String has = request.getParameter("hashtag") == null ? "" : request.getParameter("hashtag");
		
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserService.findAppUserbyUserName(loginedUser.getUsername());
		List<MenuDTO> listMenu = menuService.getAllMenubyuser("1","",user.getUserId());
		System.out.println(listMenu.size());
		request.setAttribute("listMenu", listMenu);
		
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
		return "user/edit/manage_menu";
	}
}
