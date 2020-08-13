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

import com.capstone.model.HashTagDTO;
import com.capstone.service.HashTagService;

@Controller
public class AdminHashTagController {

	@Autowired
	private HashTagService tagService;

	@GetMapping(value = "/admin/tag/search")
	public String searchTag(HttpServletRequest request
//			,
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "page", required = false) Integer page
			) {
//		final int PAGE_SIZE = 50;
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword;
//		int totalPage = tagService.countTagWhensearch(keyword);
//		int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
//		// mac dinh 10 ban ghi 1 trang
		List<HashTagDTO> tagList = tagService.getAllTags("");
//		List<Integer> listCount = new ArrayList<Integer>();
//		for(int i=1;i<=pageCount;i++) {
//			listCount.add(i);
//		}
		request.setAttribute("tagList", tagList);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("listCount", listCount);
		return "admin/hashtag/manage-tag";
	}
	
	@GetMapping(value = "/admin/tag/insert")
    public String TagInsert() {       
        return "admin/hashtag/add-tag";
    }
	
	@PostMapping(value = "/admin/tag/insert")
	public String AdminAddTagPost(@ModelAttribute(name = "addtag") HashTagDTO tag) {		
		tagService.addTag(tag);
		return "redirect:/admin/tag/search";

	}
	
	@GetMapping(value = "/admin/tag/update")
	public String AdminUpdateTagGet(Model model, @RequestParam(name = "id") int id) {
		HashTagDTO tag = tagService.getTagbyId(id);
		model.addAttribute("tag", tag);
		return "admin/hashtag/edit-tag";
	}

	@PostMapping(value = "/admin/tag/update")
	public String AdminUpdateTagPost(@ModelAttribute(name = "tag") HashTagDTO tag) {
		tagService.updateTag(tag);
		return "redirect:/admin/tag/search";
	}
			

	@GetMapping(value = "/admin/tag/delete")
	public String deleteTag(int id) {
		tagService.deleteTag(id);;
		return "redirect:/admin/tag/search";
	}
	
	@GetMapping(value = "/admin/tag/mokhoa")
	public String mokhoaTag(@RequestParam(name="id") int id) {
		HashTagDTO tag = tagService.getTagbyId(id);
		tag.setEnable("1");
		tagService.updateTag(tag);
		return "redirect:/admin/tag/search";
	}
	@GetMapping(value = "/admin/tag/khoa")
	public String khoaTag(@RequestParam(name="id") int id) {
		HashTagDTO tag = tagService.getTagbyId(id);
		tag.setEnable("0");
		tagService.updateTag(tag);
		return "redirect:/admin/tag/search";
	}
	
	
}
