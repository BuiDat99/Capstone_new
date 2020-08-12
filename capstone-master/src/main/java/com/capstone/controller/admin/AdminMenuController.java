package com.capstone.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.model.ProductDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.MenuProductService;
import com.capstone.service.MenuService;
import com.capstone.service.ProductService;

@Controller
public class AdminMenuController {
 
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuProductService mpService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/admin/menu/search")
	public String searchMenu(HttpServletRequest request) {
		
		List<MenuDTO> listMenu = menuService.getAllMenu();
		request.setAttribute("listMenu", listMenu);
		for(MenuDTO menuDTO:listMenu) {
			List<MenuProductDTO> dtos= (menuDTO.getMenuProductDTOs());
//			for(MenuProductDTO menuProductDTO:dtos) {
//				System.out.println(menuProductDTO.getProduct().getId());
//				System.out.println(menuProductDTO.getProduct().getProductName());
//			}
		}
		
		List<ProductDTO> productDTOs= productService.getAllProducts();
		request.setAttribute("listProduct", productDTOs);
		return "admin/menu/manage-menu";
	}
	@GetMapping(value = "/admin/menu/add-menu")
	public String addMenuGet(HttpServletRequest request) {
		List<ProductDTO> productDTOs= productService.getAllProducts();
		request.setAttribute("listProduct", productDTOs);
		return "admin/menu/add-menu";
	}
	
	@PostMapping(value = "/admin/menu/add-menu")
	@ResponseBody
	public MenuDTO addMenuPost(HttpServletRequest request ,
			@RequestBody MenuDTO menuDTO) {
		MenuDTO dto = menuDTO;
		menuService.addMenu(dto);
		for(String string: menuDTO.getListproductId()) {
			System.out.println(string);
			MenuProductDTO menuProductDTO= new MenuProductDTO();
			ProductDTO productDTO= productService.getProductbyId(Integer.parseInt(string));
			menuProductDTO.setMenu(dto);
			menuProductDTO.setProduct(productDTO);
			mpService.addMenuProduct(menuProductDTO);
		}
		return menuDTO;
	}
	@GetMapping(value = "/admin/menu/edit-menu")
	public String updateMenuGet(HttpServletRequest request,@RequestParam (name="id") int id ,Model model) {
		MenuDTO menuDTO=menuService.getMenubyId(id);
		model.addAttribute("menuDTO", menuDTO);
		
		List<MenuProductDTO> dtos=menuDTO.getMenuProductDTOs();
		request.setAttribute("listMP",dtos );
		return "admin/menu/edit-menu";
	}
	
	@PostMapping(value = "/admin/menu/edit-menu")
	@ResponseBody
	public MenuDTO updateMenuPost(HttpServletRequest request ,
			@RequestBody MenuDTO menuDTO) {
		System.out.println(menuDTO);
		//menuService.updateMenu(menuDTO);
		return menuDTO;
		
	}
	@GetMapping(value = "/admin/product")
	public @ResponseBody List<ProductDTO> getAllProduct() {
		return productService.getAllProducts();
	}
}
