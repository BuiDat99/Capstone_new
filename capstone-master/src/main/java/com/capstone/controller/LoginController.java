package com.capstone.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.dao.AppUserDAO;
import com.capstone.dao.UserRoleDAO;
import com.capstone.entity.AppRole;
import com.capstone.entity.AppUser;
import com.capstone.entity.UserRole;
import com.capstone.google.GooglePojo;
import com.capstone.google.GoogleUtils;
import com.capstone.model.AppUserDTO;
import com.capstone.model.UserHistoryDTO;
import com.capstone.repository.AppUserRepository;
import com.capstone.service.AppUserService;
import com.capstone.service.UserHistoryService;
import com.capstone.utils.EncrytedPasswordUtils;
import com.capstone.utils.ImgurUtil;
import com.capstone.utils.WebUtils;

@Controller
public class LoginController {
	@Autowired
	private ImgurUtil imgurUtil;

	@Autowired
	private AppUserDAO userDao;

	@Autowired
	private AppUserService userService;

	@Autowired
	private AppUserRepository userRepository;
	@Autowired
	private UserRoleDAO userRoleDao;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private GoogleUtils googleUtils;
	@Autowired
	UserHistoryService historyService;

	@RequestMapping("/login-google")
	public String loginGoogle(HttpServletRequest request, Model model) throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			return "redirect:/login?google=error";
		}
		String accessToken = googleUtils.getToken(code);

		GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
		Boolean check = userService.checkExistUserEmail(googlePojo.getEmail());
		AppUserDTO userDTO = new AppUserDTO();
		if (!check) {

			userDTO.setUsername(googlePojo.getEmail());
			userDTO.setPassword("");
			userDTO.setEmail(googlePojo.getEmail());
			userDTO.setEnable("1");

			userService.insert(userDTO);
			AppUser user = userDao.get(userDTO.getUserId());
			AppRole r = new AppRole();
			r.setRoleId(2);

			UserRole ur = new UserRole();
			ur.setAppUser(user);
			ur.setAppRole(r);

			userRoleDao.addUserRole(ur);
		}

		UserDetails userDetail = userDetailsService.loadUserByUsername(googlePojo.getEmail());
		// UserDetails userDetail = googleUtils.buildUser(googlePojo);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// add to database
//		AppUser user = new AppUser();
//		Boolean b = userRepository.existsByEmail(googlePojo.getEmail());
//		if (b != true) {
//			user.setUserName(googlePojo.getName());
//			user.setEncrytedPassword("null");
//			user.setEmail(googlePojo.getEmail());
//			user.setEnabled("1");
//			userDao.insert(user);
//
//			AppRole r = new AppRole();
//			r.setRoleId(2);
//
//			UserRole ur = new UserRole();
//			ur.setAppUser(user);
//			ur.setAppRole(r);
//
//			userRoleDao.addUserRole(ur);
//		}
		model.addAttribute("userInfo", userDTO);
		return "redirect:/login-success";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);

		return "admin/blank";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model, @RequestParam(name="error", required = false) String err,HttpServletRequest request) {
		if(err!=null) {request.setAttribute("err", "1");}
		return "user/loginP";
	}

	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginPageh(Model model, @RequestParam(name="error", required = false) String err,HttpServletRequest request) {
		if(err!=null) {request.setAttribute("err", "1");}
		return "user/loginsuccess";
	}
	

//    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//        model.addAttribute("title", "Logout");
//        return "redirect:/login";
//    }

	@RequestMapping(value = "/user/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal, HttpSession session, HttpServletRequest request) {

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();
		System.out.println("User Name: " + userName);
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = userDao.findAppUserbyUserName(loginedUser.getUsername());
		AppUserDTO userDTO = userService.get(user.getUserId());
		System.out.println(userDTO.getPassword());
		if (user.getEnabled().equals("0")) {
			return "redirect:/logout";
		}

		String userInfo = WebUtils.toString(loginedUser);
		if (userInfo.contains("ROLE_ADMIN")) {
			return "redirect:/admin";
		}
		model.addAttribute("userInfo", userDTO);
		session.setAttribute("userInfo", userDTO);
		List<UserHistoryDTO> userHistoryDTOs = historyService.searchUserHistory(userDTO.getUserId());
		// int a= userHistoryDTOs.size();
		if (userHistoryDTOs.size() != 0) {
			UserHistoryDTO dto = userHistoryDTOs.get(userHistoryDTOs.size() - 1);
			request.setAttribute("dto", dto);
		} else {
			UserHistoryDTO dto = new UserHistoryDTO();
			request.setAttribute("dto", dto);
		}

		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}
		request.setAttribute("userDTO", userDTO);
		

		return "user/userInfoPage";

	}

	@RequestMapping(value = "/user/userInfo", method = RequestMethod.POST)
	@ResponseBody
	public int userupdateInfo(Model model, HttpSession session, @ModelAttribute AppUserDTO appUserDTO,
			@RequestParam(name = "desire", required = false) String desire,
			@RequestParam(name = "height", required = false) float height,
			@RequestParam(name = "weight", required = false) float weight, Principal principal,
			@RequestParam(name = "imageFile", required = false) MultipartFile file) {

		appUserDTO.setEnable("1");
		appUserDTO.setAvata(appUserDTO.getAvata());
		String avata = imgurUtil.uploadImage(file);
		if (avata != null) {
			appUserDTO.setAvata(avata);
		}
		userService.update(appUserDTO);

		float heights = height / 100;
		float bmi = weight / (heights * heights);

		Date date = new Date();
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = userDao.findAppUserbyUserName(loginedUser.getUsername());
		AppUserDTO UserDTO = userService.get(user.getUserId());
		UserHistoryDTO userHistoryDTO = new UserHistoryDTO();
		userHistoryDTO.setHeight(height);
		userHistoryDTO.setWeight(weight);
		userHistoryDTO.setBmi(bmi);
		userHistoryDTO.setAppUser(UserDTO);
		userHistoryDTO.setDesire(desire);
		userHistoryDTO.setTrack_Results("a");
		userHistoryDTO.setCreation_Date(date.toString());
		historyService.add(userHistoryDTO);

		return 0;
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
		user.setPassword(user.getPassword());

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
		return "user/registersuccess";
	}

//	@RequestMapping(value = "/bmi", method = RequestMethod.GET)
//	public String calculateBMI(Model model) {
//		return "/user/result_bmi_caculate";
//	}
	@GetMapping(value = "/about")
	public String ABout(Model model) {
		return "/user/about";
	}
}
