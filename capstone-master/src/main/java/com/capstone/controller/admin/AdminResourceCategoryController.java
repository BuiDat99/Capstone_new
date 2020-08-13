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
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.service.ResourceCategoryService;

@Controller
public class AdminResourceCategoryController {

	@Autowired
	private ResourceCategoryService categoryService;
	
	@GetMapping(value = "/admin/resourceCat/search")
	public String searchCategory(HttpServletRequest request
//			,
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "page", required = false) Integer page
			) {
//		final int PAGE_SIZE = 7;
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword;
//		int totalPage = categoryService.countCategoryWhensearch(keyword);
//		int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
//		// mac dinh 10 ban ghi 1 trang
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories("");
//		List<Integer> listCount = new ArrayList<Integer>();
//		for(int i=1;i<=pageCount;i++) {
//			listCount.add(i);
//		}
		request.setAttribute("categoryList", categoryList);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("listCount", listCount);
		return "admin/resourceCategory/manage-resoures-category";
	}
	
	@GetMapping(value = "/admin/resourceCat/insert")
    public String CategoryInsert() {       
        return "admin/resourceCategory/add-resources-category";
    }
	@GetMapping(value = "/admin/resourceCat/khoa")
    public String Categorykhoa(@RequestParam(name="id") int id) {   
		ResourceCategoryDTO category = categoryService.getCategorybyId(id);
		category.setEnable("0");
		categoryService.updateCategory(category);
		return "redirect:/admin/resourceCat/search";
    }
	@GetMapping(value = "/admin/resourceCat/mokhoa")
    public String Categorymokhoa(@RequestParam(name="id") int id) {   
		ResourceCategoryDTO category = categoryService.getCategorybyId(id);
		category.setEnable("1");
		categoryService.updateCategory(category);
		return "redirect:/admin/resourceCat/search";
    }
	
	@PostMapping(value = "/admin/resourceCat/insert")
	public String AdminAddCategoryPost(@ModelAttribute(name = "addCategory") ResourceCategoryDTO category) {		
		categoryService.addCategory(category);
		return "redirect:/admin/resourceCat/search";

	}
	
	@GetMapping(value = "/admin/resourceCat/update")
	public String AdminUpdateCategoryGet(Model model, @RequestParam(name = "id") int id) {
		ResourceCategoryDTO category = categoryService.getCategorybyId(id);
		model.addAttribute("category", category);
		return "admin/resourceCategory/edit-resources-category";
	}

	@PostMapping(value = "/admin/resourceCat/update")
	public String AdminUpdateCategoryPost(@ModelAttribute(name = "category") ResourceCategoryDTO category) {
		categoryService.updateCategory(category);
		return "redirect:/admin/resourceCat/search";
	}
			

	@GetMapping(value = "/admin/resourceCat/delete")
	public String deleteCategory(int id) {
		categoryService.deleteCategory(id);
		return "redirect:/admin/resourceCat/search";
	}
}
