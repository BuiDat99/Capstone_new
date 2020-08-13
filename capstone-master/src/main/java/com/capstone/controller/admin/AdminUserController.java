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

import com.capstone.entity.AppUser;
import com.capstone.entity.UserRole;
import com.capstone.model.AppUserDTO;
import com.capstone.model.UserRoleDTO;
import com.capstone.repository.AppUserRepository;
import com.capstone.repository.UserRoleRepository;
import com.capstone.service.AppUserService;
import com.capstone.service.UserRoleService;

@Controller
public class AdminUserController {
	@Autowired
	private AppUserService userService;

	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private AppUserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	@GetMapping(value = "/admin/user/search")
	public String searchUser(HttpServletRequest request) {

		List<AppUserDTO> userList = userService.getAllUser();
		for(AppUserDTO udto:userList) {
			AppUser u = userRepository.findById(udto.getUserId()).get();
			List<String> roles = new ArrayList<String>();
			List<UserRole> urLists = userRoleRepository.findAll();
			for(UserRole ur:urLists) {
				if(ur.getAppUser().getUserId() == u.getUserId()) {
					roles.add(ur.getAppRole().getRoleName());
				}
			}
			udto.setRoles(roles);
		}

		request.setAttribute("userList", userList);
		return "admin/user/manage-user";
	}

	@GetMapping(value = "/admin/user/insert")
	public String AdminAddUserGet() {
		return "admin/user/userAdd";
	}
	@GetMapping(value = "/admin/user/mokhoa")
	public String AdminmokhoaUserGet(@RequestParam (name="id") int id) {
		AppUserDTO appUserDTO= userService.get(id);
		appUserDTO.setEnable("1");
		userService.update(appUserDTO);
		return "redirect:/admin/user/search";
	}
	@GetMapping(value = "/admin/user/khoa")
	public String AdminkhoaUserGet(@RequestParam (name="id") int id) {
		AppUserDTO appUserDTO= userService.get(id);
		appUserDTO.setEnable("0");
		userService.update(appUserDTO);
		return "redirect:/admin/user/search";
	}

	@PostMapping(value = "/admin/user/insert")
	public String AdminAddUserPost(@ModelAttribute(name = "adduser") AppUserDTO user) {
		userService.insert(user);
		return "redirect:/admin/user/search";

	}

	@GetMapping(value = "/admin/user/update")
	public String AdminUpdateUserGet(HttpServletRequest request,Model model, @RequestParam(name = "id") int id) {
		AppUserDTO user = userService.get(id);
		model.addAttribute("user", user);
		UserRoleDTO userRoles = userRoleService.getUserRolebyId(id);
		request.setAttribute("userRoles", userRoles);
		return "admin/user/edit-user";
	}

	@PostMapping(value = "/admin/user/update")
	public String changePassword(@ModelAttribute(name = "user") AppUserDTO user,UserRoleDTO ur) {		
		userRoleService.updateUserRole(ur);		
		return "redirect:/admin/user/search";
	}

	@GetMapping(value = "/admin/user/delete")
	public String deleteUser(int id) {
		userService.delete(id);
		return "redirect:/admin/user/search";
	}
}
