package com.capstone.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capstone.google.GooglePojo;
import com.capstone.google.GoogleUtils;
import com.capstone.model.AppUserDTO;
import com.capstone.service.AppUserService;
import com.capstone.utils.EncrytedPasswordUtils;
import com.capstone.utils.WebUtils;

@Controller
public class LoginController {

	@Autowired
	private AppUserService userService;

	@Autowired
	private GoogleUtils googleUtils;

	@Autowired
	private UserDetailsService userDetailsService;

	@RequestMapping("/login-google")
	public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			return "redirect:/login?google=error";
		}
		String accessToken = googleUtils.getToken(code);

		GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);

		// add to database
		Boolean check = userService.checkExistUserEmail(googlePojo.getEmail());
		if (!check) {
			AppUserDTO userDTO = new AppUserDTO();

			userDTO.setUsername(googlePojo.getEmail());
			userDTO.setPassword("123456");
			userDTO.setEmail(googlePojo.getEmail());
			userDTO.setEnable("1");

			userService.insert(userDTO);
		}

		UserDetails userDetail = userDetailsService.loadUserByUsername(googlePojo.getEmail());

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		return "user/userInfoPage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "admin/blank";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		return "user/loginP";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal, HttpSession session) {
		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();
		System.out.println("User Name: " + userName);
		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		if (userInfo.contains("ROLE_ADMIN")) {
			return "redirect:/admin";
		}

		return "user/userInfoPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();

			String userInfo = WebUtils.toString(loginedUser);

			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "403Page";
	}

	@GetMapping(value = "/register")
	public String registerPage(Model model) {
		return "/user/register";
	}

	@PostMapping(value = "/register") // Fix check exist User by Thang Pan
	public String addUser(HttpServletRequest request, @ModelAttribute AppUserDTO user) {

		user.setEnable("1");
		user.setPassword(EncrytedPasswordUtils.encrytePassword(user.getPassword()));

		if (userService.checkExistUser(user.getUsername())) {
			System.out.print("------------------EXIST------------");
			request.setAttribute("messErr", "User " + user.getUsername() + " existed!");
			return "/user/register";
		} else if (userService.checkExistUserEmail(user.getEmail())) {
			System.out.print("------------------EXIST------------");
			request.setAttribute("messErr", "Email " + user.getEmail() + " existed!");
			return "/user/register";
		}
		System.out.print("------------------NOT EXIST------------");
		userService.insert(user);
		return "redirect:/login";
	}
}
