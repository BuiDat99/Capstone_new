package com.capstone.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.model.ResourceCategoryDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ResourceCategoryService;
import com.capstone.service.ResourceService;
import com.capstone.utils.ImgurUtil;

@Controller
public class AdminResourceController {
	@Autowired
	private ImgurUtil imgurUtil;
	@Autowired
	private ResourceCategoryService categoryService;
	@Autowired
	private ResourceService resourceService;

	@GetMapping(value = "/admin/resource/search")
	public String searchResource(HttpServletRequest request
	// ,
	// @RequestParam(value = "keyword", required = false) String keyword,
	// @RequestParam(value = "page", required = false) Integer page
	) {
		// final int PAGE_SIZE = 100;
		// page = page == null ? 1 : page;
		// keyword = keyword == null ? "" : keyword;
		// int totalPage = resourceService.countResourceWhensearch(keyword);
		// int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE :
		// totalPage / PAGE_SIZE + 1;
		// mac dinh 10 ban ghi 1 trang
		List<ResourceDTO> resourceList = resourceService.getAllResources("");
		// List<Integer> listCount = new ArrayList<Integer>();
		// for(int i=1;i<=pageCount;i++) {
		// listCount.add(i);
		// }
		request.setAttribute("resourceList", resourceList);
		// request.setAttribute("page", page);
		// request.setAttribute("keyword", keyword);
		// request.setAttribute("listCount", listCount);
		return "admin/resource/manage-resoures";
	}

	@GetMapping(value = "/admin/resource/insert")
	public String ResourceInsert(HttpServletRequest request, Model model) {
		model.addAttribute("resource", new ResourceDTO());
		List<ResourceCategoryDTO> list = categoryService.search("1", "", 0, 100);
		request.setAttribute("categoryList", list);
		return "admin/resource/add-resources";
	}

	@PostMapping(value = "/admin/resource/insert")
	public @ResponseBody void AdminAddResourcePost(
			@RequestParam(value = "resourceName", required = false) String resourceName,
			@RequestParam(value = "resourceDescription", required = false) String resourceDescription,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "kcal1g", required = false) Float kcal1g,
			@RequestParam(value = "category", required = false) String category) {
		ResourceCategoryDTO categoryDTO = new ResourceCategoryDTO();
		categoryDTO.setId(Integer.parseInt(category));
		ResourceDTO resource = new ResourceDTO();
		resource.setResourceName(resourceName);
		resource.setResourceDescription(resourceDescription);
		resource.setKcal1g(kcal1g);
		resource.setCategory(categoryDTO);
		resource.setImage(imgurUtil.uploadImage(file));
		resourceService.addResource(resource);

	}

	@GetMapping(value = "/admin/resource/khoa")
	public String AdminkhoaResourcePost(@RequestParam(name = "id") int id) {
		ResourceDTO resource = resourceService.getResourcebyId(id);

		resource.setEnable("0");
		resource.setCategory(resource.getCategory());
		resourceService.updateResource(resource);
		return "redirect:/admin/resource/search";

	}

	@GetMapping(value = "/admin/resource/mokhoa")
	public String AdminmokhoaResourcePost(@RequestParam(name = "id") int id) {
		ResourceDTO resource = resourceService.getResourcebyId(id);

		resource.setEnable("1");
		resource.setCategory(resource.getCategory());
		resourceService.updateResource(resource);
		return "redirect:/admin/resource/search";

	}

	@GetMapping(value = "/admin/resource/update")
	public String AdminUpdateResourceGet(HttpServletRequest request, Model model, @RequestParam(name = "id") int id) {
		ResourceDTO resource = resourceService.getResourcebyId(id);
		List<ResourceCategoryDTO> list = categoryService.search("1", "", 0, 100);

		model.addAttribute("resource", resource);
		request.setAttribute("categoryList", list);
		return "admin/resource/edit-resources";
	}

	@PostMapping(value = "/admin/resource/update")
	@ResponseBody
	public void AdminUpdateResourcePost(@RequestParam(value = "resourceName", required = false) String resourceName,
			@RequestParam(value = "resourceDescription", required = false) String resourceDescription,
			@RequestParam(value = "id", required = false) int id,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "kcal1g", required = false) Float kcal1g,
			@RequestParam(value = "category", required = false) String category) {
		ResourceCategoryDTO categoryDTO = new ResourceCategoryDTO();
		categoryDTO.setId(Integer.parseInt(category));
		ResourceDTO resource = new ResourceDTO();
		resource.setEnable("1");
		ResourceDTO dto = resourceService.getResourcebyId(id);
		resource.setResourceName(resourceName);
		resource.setId(id);
		resource.setResourceDescription(resourceDescription);
		resource.setKcal1g(kcal1g);
		resource.setCategory(categoryDTO);
		resource.setImage(dto.getImage());
		String image = imgurUtil.uploadImage(file);
		if (image != null) {
			resource.setImage(image);
		}
		resourceService.updateResource(resource);

	}

	@GetMapping(value = "/admin/resource/delete")
	public String deleteResource(int id) {
		resourceService.deleteResource(id);
		return "redirect:/admin/resource/search";
	}

	@GetMapping(value = "/admin/resource/resourceCat/{id}")
	public @ResponseBody List<ResourceDTO> getResourceFromResouceCategory(@PathVariable("id") int id) {
		return resourceService.getResourceFromWithResouceCatId(id);
	}
}
