package com.capstone.controller.user;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;
import com.capstone.model.AppUserDTO;
import com.capstone.model.UserHistoryDTO;
import com.capstone.service.AppUserService;
import com.capstone.service.UserHistoryService;

@Controller
public class UserCalculateController {
	@Autowired
	UserHistoryService historyService;

	@Autowired
	AppUserService appUserService;

	@Autowired
	AppUserDAO appUserDao;

	@RequestMapping(value = "/bfp", method = RequestMethod.GET) // ham Dat viet
	public String calculateBFP(Model model, HttpServletRequest request, HttpSession httpSession) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		return "user/result_bfp_caculate";
	}

	@RequestMapping(value = "/bmr", method = RequestMethod.GET) // ham Dat viet
	public String calculateBMR(Model model, HttpSession httpSession, HttpServletRequest request) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		return "user/result_bmr_caculate";
	}

	@RequestMapping(value = "/bmi", method = RequestMethod.GET) // ham Dat viet
	public String calculateBMI(Model model, HttpSession httpSession, HttpServletRequest request) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		return "user/result_bmi_caculate";
	}

	@RequestMapping(value = "/user/bmi", method = RequestMethod.GET) // ham Dat viet
	public String calculateBMIuser(Model model, HttpSession httpSession, HttpServletRequest request) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		return "user/result_bmi_caculate";
	}

	@PostMapping(value = "/bmi")
	public String CalBMI(HttpServletRequest request, @RequestParam(name = "weight", required = true) String weight,
			@RequestParam(name = "height", required = true) String height,
			@RequestParam(name = "inlineRadioOptions", required = true) String gender, Model model, Principal principal,
			HttpSession httpSession) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		if (Float.parseFloat(weight) < 1 || Float.parseFloat(weight) > 300) {
			request.setAttribute("messErr", "Vui lòng nhập cân nặng từ 1 cân đến 300 cân");
			return "user/result_bmi_caculate";
		} else if (Float.parseFloat(height) < 1 || Float.parseFloat(height) > 300) {
			request.setAttribute("messErr", "Vui lòng nhập chiều cao từ 1cm đến 300cm");
			return "user/result_bmi_caculate";
		}

		float heights = Float.parseFloat(height) / 100;
		float bmi = Float.parseFloat(weight) / (heights * heights);
		String tinhtrangBMI = null;

		List<String> hashtags = new ArrayList<String>();

		if (bmi < 16) {
			tinhtrangBMI = "Gầy độ 3";
			hashtags.add("tangcan");
			hashtags.add("gay3");
			hashtags.add("anuongdieudo");
		} else if (bmi >= 16 && bmi < 17) {
			tinhtrangBMI = "Gầy độ 2";
			hashtags.add("tangcan");
			hashtags.add("gay2");
			hashtags.add("anuongdieudo");
		} else if (bmi >= 17 && bmi < 18.5) {
			tinhtrangBMI = " Gầy độ 1";
			hashtags.add("tangcan");
			hashtags.add("gay1");
			hashtags.add("anuongdieudo");
		} else if (bmi >= 18.5 && bmi < 25) {
			tinhtrangBMI = " Bình thường";
			hashtags.add("sietco");
			hashtags.add("tangco");
			hashtags.add("boruou");
		} else if (bmi >= 25 && bmi < 30) {
			tinhtrangBMI = " Thừa cân";
			hashtags.add("giamcan");
			hashtags.add("beo");
			hashtags.add("anit");
		} else if (bmi >= 30 && bmi < 35) {
			tinhtrangBMI = " Béo phì cấp độ 1";
			hashtags.add("giamcan");
			hashtags.add("beo1");
			hashtags.add("anit");
		} else if (bmi >= 35 && bmi < 40) {
			tinhtrangBMI = " Béo phì cấp độ 2";
			hashtags.add("giamcan");
			hashtags.add("beo2");
			hashtags.add("anit");
		} else if (bmi > 40) {
			tinhtrangBMI = " Béo phì cấp độ 3";
			hashtags.add("giamcan");
			hashtags.add("beo3");
			hashtags.add("anit");
		}

		bmi = Float.parseFloat(new DecimalFormat("##.###").format(bmi));
		Date date = new Date();
		model.addAttribute("bmi", bmi);
		model.addAttribute("tinhtrang", tinhtrangBMI);
		model.addAttribute("hashtags", hashtags);

		return "user/result_bmi_caculate";

	}

	@PostMapping(value = "/user/bmi")
	public String userCalBMI(HttpServletRequest request, @RequestParam(name = "weight", required = true) String weight,
			@RequestParam(name = "height", required = true) String height,
			@RequestParam(name = "inlineRadioOptions", required = true) String gender, Model model, Principal principal,
			HttpSession httpSession) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		if (Float.parseFloat(weight) < 1 || Float.parseFloat(weight) > 300) {
			request.setAttribute("messErr", "Vui lòng nhập cân nặng từ 1 cân đến 300 cân");
			return "user/result_bmi_caculate";
		} else if (Float.parseFloat(height) < 1 || Float.parseFloat(height) > 300) {
			request.setAttribute("messErr", "Vui lòng nhập chiều cao từ 1cm đến 300cm");
			return "user/result_bmi_caculate";
		}

		float heights = Float.parseFloat(height) / 100;
		float bmi = Float.parseFloat(weight) / (heights * heights);
		String tinhtrangBMI = null;

		List<String> hashtags = new ArrayList<String>();

		if (bmi < 16) {
			tinhtrangBMI = "Gầy độ 3";
			hashtags.add("tangcan");
			hashtags.add("gay3");
			hashtags.add("anuongdieudo");
		} else if (bmi >= 16 && bmi < 17) {
			tinhtrangBMI = "Gầy độ 2";
			hashtags.add("tangcan");
			hashtags.add("gay2");
			hashtags.add("anuongdieudo");
		} else if (bmi >= 17 && bmi < 18.5) {
			tinhtrangBMI = " Gầy độ 1";
			hashtags.add("tangcan");
			hashtags.add("gay1");
			hashtags.add("anuongdieudo");
		} else if (bmi >= 18.5 && bmi < 25) {
			tinhtrangBMI = " Bình thường";
			hashtags.add("sietco");
			hashtags.add("tangco");
			hashtags.add("boruou");
		} else if (bmi >= 25 && bmi < 30) {
			tinhtrangBMI = " Thừa cân";
			hashtags.add("giamcan");
			hashtags.add("beo");
			hashtags.add("anit");
		} else if (bmi >= 30 && bmi < 35) {
			tinhtrangBMI = " Béo phì cấp độ 1";
			hashtags.add("giamcan");
			hashtags.add("beo1");
			hashtags.add("anit");
		} else if (bmi >= 35 && bmi < 40) {
			tinhtrangBMI = " Béo phì cấp độ 2";
			hashtags.add("giamcan");
			hashtags.add("beo2");
			hashtags.add("anit");
		} else if (bmi > 40) {
			tinhtrangBMI = " Béo phì cấp độ 3";
			hashtags.add("giamcan");
			hashtags.add("beo3");
			hashtags.add("anit");
		}
		bmi = Float.parseFloat(new DecimalFormat("##.###").format(bmi));
		Date date = new Date();
		model.addAttribute("bmi", bmi);
		model.addAttribute("tinhtrang", tinhtrangBMI);
		model.addAttribute("hashtags", hashtags);

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		if (loginedUser != null) {
			AppUser user = appUserDao.findAppUserbyUserName(loginedUser.getUsername());
			AppUserDTO appUserDTO = appUserService.get(user.getUserId());
			UserHistoryDTO userHistoryDTO = new UserHistoryDTO();
			userHistoryDTO.setHeight(height);
			userHistoryDTO.setWeight(weight);
			userHistoryDTO.setBmi(String.valueOf(bmi));
			userHistoryDTO.setAppUser(appUserDTO);
			userHistoryDTO.setDesire("a");
			userHistoryDTO.setTrack_Results("a");
			userHistoryDTO.setCreation_Date(date.toString());
			historyService.add(userHistoryDTO);
		}

		return "user/result_bmi_caculate";

	}

	@PostMapping(value = "/bfp")
	public String CalBFP(HttpServletRequest request, @RequestParam(name = "age", required = true) double age,
			@RequestParam(name = "weight", required = true) String weight,
			@RequestParam(name = "height", required = true) String height,
			@RequestParam(name = "inlineRadioOptions", required = true) String gender, Model model,
			HttpSession httpSession) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		if (Float.parseFloat(weight) < 1 || Float.parseFloat(weight) > 300) {
			request.setAttribute("messErr", "Vui lòng nhập cân nặng từ 1 cân đến 300 cân");
			return "user/result_bfp_caculate";
		} else if (Float.parseFloat(height) < 1 || Float.parseFloat(height) > 300) {
			request.setAttribute("messErr", "Vui lòng nhập chiều cao từ 1cm đến 300cm");
			return "user/result_bfp_caculate";
		} else if (age < 2 || age > 98) {
			request.setAttribute("messErr", "Vui lòng nhập tuổi từ 2 - 98");
			return "user/result_bfp_caculate";
		}

		Float heights = Float.parseFloat(height) / 100;
		Float bmi = Float.parseFloat(weight) / (heights * heights);
		double bfp = 0;
		String tinhtrangBFP = " ";
		if (gender.equals("male")) {
			bfp = 1.20 * bmi + 0.23 * age - 16.2;
			if (bfp >= 2 && bfp <= 5) {
				tinhtrangBFP = "Essential fat";
			}
			if (bfp > 5 && bfp <= 13) {
				tinhtrangBFP = "Athletes ";
			}
			if (bfp > 13 && bfp <= 17) {
				tinhtrangBFP = "Fitness";
			}
			if (bfp > 17 && bfp <= 25) {
				tinhtrangBFP = "Average";
			}
			if (bfp > 25) {
				tinhtrangBFP = "Obese";
			}
		} else if (gender.equals("female")) {
			bfp = 1.20 * bmi + 0.23 * age - 5.4;
			if (bfp >= 10 && bfp <= 13) {
				tinhtrangBFP = "Essential fat";
			}
			if (bfp > 13 && bfp <= 20) {
				tinhtrangBFP = "Athletes ";
			}
			if (bfp > 20 && bfp <= 24) {
				tinhtrangBFP = "Fitness";
			}
			if (bfp > 24 && bfp <= 31) {
				tinhtrangBFP = "Average";
			}
			if (bfp > 31) {
				tinhtrangBFP = "Obese";
			}
		}
		bfp = Double.parseDouble(new DecimalFormat("##.###").format(bfp));
		model.addAttribute("tinhtrangbfp", tinhtrangBFP);
		model.addAttribute("bfp", bfp);
		return "user/result_bfp_caculate";
	}

	@PostMapping(value = "/bmr")
	public String CalBMR(HttpServletRequest request, @RequestParam(name = "age", required = true) float age,
			@RequestParam(name = "weight", required = true) String weight,
			@RequestParam(name = "height", required = true) String height,
			@RequestParam(name = "inlineRadioOptions", required = true) String gender,
			@RequestParam(name = "cuongdo", required = true) String cuongdo, Model model, HttpSession httpSession) {
		AppUserDTO userDTO = (AppUserDTO) httpSession.getAttribute("userInfo");
		request.setAttribute("userDTO", userDTO);
		if (userDTO != null) {
			if (userDTO.getAvata() != null) {
				System.out.println(" co avata");
				String check = "yes";
				request.setAttribute("check", check);
			}
		}

		double heights = Float.parseFloat(height) / 100;
		double bmr = 0;
		double bfp = 0;
		double bmi = Float.parseFloat(weight) / (heights * heights);
		double tdee = 0;
		if (gender.equals("male")) {
			bfp = 1.20 * bmi + 0.23 * age - 16.2;
		} else if (gender.equals("female")) {
			bfp = 1.20 * bmi + 0.23 * age - 5.4;
		}

		bmr = 21.6 * Float.parseFloat(weight) * (100 - bfp) / 100;

		if (cuongdo.equals("it")) {
			tdee = bmr * 1.2;
		} else if (cuongdo.equals("nhe")) {
			tdee = bmr * 1.375;
		} else if (cuongdo.equals("vuaphai")) {
			tdee = bmr * 1.55;
		} else if (cuongdo.equals("nhieu")) {
			tdee = bmr * 1.725;
		} else if (cuongdo.equals("ratnhieu")) {
			tdee = bmr * 1.9;
		}
		bmr = Double.parseDouble(new DecimalFormat("##.##").format(bmr));
		tdee = Double.parseDouble(new DecimalFormat("##.##").format(tdee));

		model.addAttribute("BMR", bmr);
		model.addAttribute("tdee", tdee);

		return "user/result_bmr_caculate";

	}
}
