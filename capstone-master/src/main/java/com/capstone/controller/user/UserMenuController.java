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
import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.model.ProductDTO;
import com.capstone.service.MenuProductService;
import com.capstone.service.MenuService;
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

	@GetMapping(value = "/user/menu/add-menu")
	public String addMenuGet(HttpServletRequest request) {
		List<ProductDTO> productDTOs = productService.getAllProducts("1");
		request.setAttribute("listProduct", productDTOs);
		return "user/add-menu";
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
		MenuDTO menuDTO = menuService.getMenubyId(id);
		model.addAttribute("menuDTO", menuDTO);
		return "user/edit-menu";
	}

	@PostMapping(value = "/user/menu/edit-menu")
	@ResponseBody
	public MenuDTO updateMenuPost(HttpServletRequest request, @RequestBody MenuDTO menuDTO) {
		MenuDTO menuDTO2 = menuService.getMenubyId(menuDTO.getId());
		menuDTO.setEnable("1");
		menuService.updateMenu(menuDTO);
		for (MenuProductDTO menuProductDTO : menuDTO2.getMenuProductDTOs()) {
			mpService.deleteMenuProduct(menuProductDTO.getId());
		}
		for (String string : menuDTO.getListproductId()) {
			
			ProductDTO productDTO = productService.getProductbyId(Integer.parseInt(string));
			MenuProductDTO menuProductDTO = new MenuProductDTO();
			menuProductDTO.setProduct(productDTO);
			menuProductDTO.setMenu(menuDTO);
			mpService.addMenuProduct(menuProductDTO);
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
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserService.findAppUserbyUserName(loginedUser.getUsername());
		List<MenuDTO> listMenu = menuService.getAllMenubyuser("1","",user.getUserId());
		System.out.println(listMenu.size());
		request.setAttribute("listMenu", listMenu);
		return "user/manage-menu";
	}
}
