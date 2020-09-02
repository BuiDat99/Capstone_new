package com.capstone.controller.user;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;
import com.capstone.model.AppUserDTO;
import com.capstone.service.AppUserService;
import com.capstone.service.EmailService;
import com.capstone.utils.PasswordGenerator;

@Controller
public class UserPasswordController {
	@Autowired
	EmailService emailService;
	@Autowired
	private AppUserDAO appUserDao;
	@Autowired
	private AppUserService appUserService;

	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	public String ChangePassGet(HttpServletRequest request,HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		return "/user/changedPassword";
	}

	@RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
	public String changeUserPassword(HttpServletRequest request,
			@RequestParam(value = "newPassword", required = false) String newPass, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		AppUser user = appUserDao.findAppUserbyUserName(loginedUser.getUsername());
		AppUserDTO userDTO = appUserService.get(user.getUserId());
		userDTO.setPassword(newPass);
		userDTO.setEnable("1");
		appUserService.changeUserPassword(userDTO);
		emailService.sendSimpleMessage(userDTO.getEmail(), "Thay đổi mật khẩu",

				"<html>" + "<body>" + "<h3>Bạn vừa đổi mật khẩu thành công !!! \n</h3>"
						+ "<p>\n Mật khẩu mới của bạn là : " + newPass
						+ " , yêu cầu bảo mật và không cung cấp mật khẩu cho bất kì ai!!!"

						+ "</body>" + "</html>");
		return "user/changepasswordsuccess";
	}

	@RequestMapping(value = "/resetPass", method = RequestMethod.GET)
	public String ResetPassGet(HttpServletRequest request, HttpSession httpSession) {
		AppUserDTO userDTO=(AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO",userDTO);
		if(userDTO!=null) {
		if (userDTO.getAvata() != null) {
			System.out.println(" co avata");
			String check = "yes";
			request.setAttribute("check", check);
		}}
		return "/user/resetPassword";
	}

	@RequestMapping(value = "/resetPass", method = RequestMethod.POST)
	public String ResetUserPassword(HttpServletRequest request,
			@RequestParam(value = "email", required = false) String email, Principal principal) {

		AppUser user = appUserService.findUserByEmail(email);

		AppUserDTO appUserDTO = appUserService.get(user.getUserId());
		String pass = PasswordGenerator.generateRandomPassword();

		appUserDTO.setPassword(pass);
		appUserDTO.setEnable("1");
		if (email.equals(appUserDTO.getEmail())) {
			appUserService.changeUserPassword(appUserDTO);
			emailService.sendSimpleMessage(appUserDTO.getEmail(), "Lấy lại mật khẩu",

					"<html>" + "<body>" + "<h3>Bạn vừa yêu cầu lấy lại mật khẩu !!! \n</h3>"
							+ "<p>\n Mật khẩu mới của bạn là : " + pass
							+ " , yêu cầu bảo mật và không cung cấp mật khẩu cho bất kì ai!!!"

							+ "</body>" + "</html>");

		}

		return "redirect:/login";
	}
}
