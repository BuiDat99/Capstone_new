package com.capstone.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.capstone.model.MenuDTO;
import com.capstone.model.MenuProductDTO;
import com.capstone.service.MenuProductService;
import com.capstone.service.MenuService;

@Controller
public class AdminMenuController {
 
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuProductService mpService;
	@GetMapping(value = "/admin/menu/search")
	public String searchMenu(HttpServletRequest request) {
		
		List<MenuDTO> listMenu = menuService.getAllMenu();
		request.setAttribute("listMenu", listMenu);
		
		List<MenuProductDTO> listMp = mpService.getAllMenuProduct();
		request.setAttribute("listMp", listMp);
		return "admin/menu/manage-menu";
	}
}
