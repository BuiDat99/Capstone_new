package com.capstone.controller.user;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public @ResponseBody List<ProductDTO> getAllProduct() {
		return productService.getAllProducts("1");
	}

}
