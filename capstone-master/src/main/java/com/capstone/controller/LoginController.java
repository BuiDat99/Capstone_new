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
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.dao.AppUserDAO;
import com.capstone.dao.UserRoleDAO;
import com.capstone.entity.AppRole;
import com.capstone.entity.AppUser;
import com.capstone.entity.UserRole;
import com.capstone.google.GooglePojo;
import com.capstone.google.GoogleUtils;
import com.capstone.model.AppUserDTO;
import com.capstone.repository.AppUserRepository;
import com.capstone.service.AppUserService;
import com.capstone.utils.EncrytedPasswordUtils;
import com.capstone.utils.WebUtils;

@Controller
public class LoginController {

	@Autowired
	private AppUserDAO userDao;

	@Autowired
	private AppUserService userService;

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private UserRoleDAO userRoleDao;

	@Autowired
	private GoogleUtils googleUtils;

	@RequestMapping("/login-google")
	public String loginGoogle(HttpServletRequest request, AppUserDTO userDTO)
			throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			return "redirect:/login?google=error";
		}
		String accessToken = googleUtils.getToken(code);

		GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
		UserDetails userDetail = googleUtils.buildUser(googlePojo);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// add to database
		AppUser user = new AppUser();
		Boolean b = userRepository.existsByEmail(googlePojo.getEmail());
		if (b != true) {
//			user.setUsername(googlePojo.getName());
//			user.setPassword("null");
//			user.setEmail(googlePojo.getEmail());
//			user.setEnable("1");
			user.setUserName(googlePojo.getName());
			user.setEncrytedPassword("null");
			user.setEmail(googlePojo.getEmail());
			user.setEnabled("1");
			userDao.insert(user);

			AppRole r = new AppRole();
			r.setRoleId(2);

			UserRole ur = new UserRole();
			ur.setAppUser(user);
			ur.setAppRole(r);

			userRoleDao.addUserRole(ur);
		}
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

//    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//        model.addAttribute("title", "Logout");
//        return "redirect:/login";
//    }

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
	@GetMapping(value = "/")
	public String HomePage() {
		return "/user/home";
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

//	@RequestMapping(value = "/bmi", method = RequestMethod.GET)
//	public String calculateBMI(Model model) {
//		return "/user/result_bmi_caculate";
//	}
}
