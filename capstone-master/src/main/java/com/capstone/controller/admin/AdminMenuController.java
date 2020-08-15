package com.capstone.controller.admin;

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
import com.capstone.dao.MenuProductDAO;
import com.capstone.entity.AppUser;
import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.model.ProductDTO;
import com.capstone.service.MenuProductService;
import com.capstone.service.MenuService;
import com.capstone.service.ProductService;

@Controller
public class AdminMenuController {
	@Autowired
	MenuProductDAO dao;

	@Autowired
	private AppUserDAO appUserService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private MenuProductService mpService;

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/admin/menu/search")
	public String searchMenu(HttpServletRequest request) {

		List<MenuDTO> listMenu = menuService.getAllMenu("", "");
		request.setAttribute("listMenu", listMenu);
		for (MenuDTO menuDTO : listMenu) {
			List<MenuProductDTO> dtos = (menuDTO.getMenuProductDTOs());
//			for(MenuProductDTO menuProductDTO:dtos) {
//				System.out.println(menuProductDTO.getProduct().getId());
//				System.out.println(menuProductDTO.getProduct().getProductName());
//			}
		}

		List<ProductDTO> productDTOs = productService.getAllProducts("1");
		request.setAttribute("listProduct", productDTOs);
		return "admin/menu/manage-menu";
	}

	@GetMapping(value = "/admin/menu/add-menu")
	public String addMenuGet(HttpServletRequest request) {
		List<ProductDTO> productDTOs = productService.getAllProducts("1");
		request.setAttribute("listProduct", productDTOs);
		return "admin/menu/add-menu";
	}

	@PostMapping(value = "/admin/menu/add-menu")
	@ResponseBody
	public MenuDTO addMenuPost(HttpServletRequest request, @RequestBody MenuDTO menuDTO, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserService.findAppUserbyUserName(loginedUser.getUsername());
		MenuDTO dto = menuDTO;
		dto.setUserId(user.getUserId());
		menuService.addMenu(dto);
		for (String string : menuDTO.getListproductId()) {
			MenuProductDTO menuProductDTO = new MenuProductDTO();
			ProductDTO productDTO = productService.getProductbyId(Integer.parseInt(string));
			menuProductDTO.setMenu(dto);
			menuProductDTO.setProduct(productDTO);
			mpService.addMenuProduct(menuProductDTO);
		}
		return menuDTO;
	}

	@GetMapping(value = "/admin/menu/edit-menu")
	public String updateMenuGet(HttpServletRequest request, @RequestParam(name = "id") int id, Model model) {
		MenuDTO menuDTO = menuService.getMenubyId(id);
		model.addAttribute("menuDTO", menuDTO);
		return "admin/menu/edit-menu";
	}

	@PostMapping(value = "/admin/menu/edit-menu")
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

	@GetMapping(value = "/admin/product")
	public @ResponseBody List<ProductDTO> getAllProduct() {
		return productService.getAllProducts("1");
	}

	@GetMapping(value = "/admin/menu/delete-menu")
	public String deleteMenuGet(HttpServletRequest request, @RequestParam(name = "id") int id) {
		menuService.deleteMenu(id);
		return "redirect:/admin/menu/search";
	}

	@GetMapping(value = "/admin/menu/khoa")
	public String khoaMenuGet(HttpServletRequest request, @RequestParam(name = "id") int id) {
		MenuDTO menuDTO = menuService.getMenubyId(id);
		menuDTO.setEnable("0");
		menuService.updateMenu(menuDTO);
		return "redirect:/admin/menu/search";
	}

	@GetMapping(value = "/admin/menu/mokhoa")
	public String mokhoaMenuGet(HttpServletRequest request, @RequestParam(name = "id") int id) {
		MenuDTO menuDTO = menuService.getMenubyId(id);
		menuDTO.setEnable("1");
		menuService.updateMenu(menuDTO);
		return "redirect:/admin/menu/search";
	}

	@GetMapping(value = "/admin/menu/t")
	public String mokhoGet(HttpServletRequest request, @RequestParam(name = "id") int id) {

		mpService.deleteMenuProduct(id);

		return "redirect:/admin/menu/search";
	}

}
