package com.capstone.controller.user;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserCalculateController {

	@RequestMapping(value = "/bfp", method = RequestMethod.GET)  //ham Dat viet
	public String calculateBFP(Model model) {
		return "/user/result_bfp_caculate";
	}
	
	@RequestMapping(value = "/bmr", method = RequestMethod.GET)  //ham Dat viet
	public String calculateBMR(Model model) {
		return "/user/result_bmr_caculate";
	}

	@RequestMapping(value = "/bmi", method = RequestMethod.GET)  //ham Dat viet
	public String calculateBMI(Model model) {
		return "/user/result_bmi_caculate";
	}
	@PostMapping(value = "/bmi")
	public String CalBMI(HttpServletRequest request,
						@RequestParam(name = "weight", required = true) double weight,
						@RequestParam(name = "height", required = true) double height,
						@RequestParam(name = "inlineRadioOptions", required = true) String gender,
						Model model) {
		
		
		if(weight < 1 || weight > 300) {
			request.setAttribute("messErr", "Vui lòng nhập cân nặng từ 1 cân đến 300 cân" );		
			return "/user/result_bmi_caculate";
		}else if(height < 1 || height > 300) {
			request.setAttribute("messErr", "Vui lòng nhập chiều cao từ 1cm đến 300cm" );			
			return "/user/result_bmi_caculate";
		}
		
		double heights = height / 100;
		double bmi = weight / (heights * heights);
		String tinhtrangBMI = null;
		
		

		if (bmi < 16) {
			tinhtrangBMI = "Gầy độ 3";
		} else if (bmi >= 16 && bmi < 17) {
			tinhtrangBMI = "Gầy độ 2";
		} else if (bmi >= 17 && bmi < 18.5) {
			tinhtrangBMI = " Gầy độ 1";
		} else if (bmi >= 18.5 && bmi < 25) {
			tinhtrangBMI = " Bình thường";
		} else if (bmi >= 25 && bmi < 30) {
			tinhtrangBMI = " Thừa cân";
		} else if (bmi >= 30 && bmi < 35) {
			tinhtrangBMI = " Béo phì cấp độ 1";
		} else if (bmi >= 35 && bmi < 40) {
			tinhtrangBMI = " Béo phì cấp độ 2";
		} else if (bmi > 40) {
			tinhtrangBMI = " Béo phì cấp độ 3";
		}
		
		bmi =Double.parseDouble(new DecimalFormat("##.###").format(bmi)); 
		
		model.addAttribute("bmi", bmi);
		model.addAttribute("tinhtrang", tinhtrangBMI);
		
		return "/user/result_bmi_caculate";

	}

	@PostMapping(value = "/bfp")
	public String CalBFP(HttpServletRequest request,
						@RequestParam(name = "age", required = true) double age,
						@RequestParam(name = "weight", required = true) double weight,
						@RequestParam(name = "height", required = true) double height,
						@RequestParam(name = "inlineRadioOptions", required = true) String gender,
						Model model) {
		
		
		if(weight < 1 || weight > 300) {
			request.setAttribute("messErr", "Vui lòng nhập cân nặng từ 1 cân đến 300 cân" );			
			return "/user/result_bfp_caculate";
		}else if(height < 1 || height > 300) {
			request.setAttribute("messErr", "Vui lòng nhập chiều cao từ 1cm đến 300cm" );			
			return "/user/result_bfp_caculate";
		}else if(age <2 || age > 98) {
			request.setAttribute("messErr", "Vui lòng nhập tuổi từ 2 - 98" );			
			return "/user/result_bfp_caculate";
		}
		
		height = height / 100;
		double bmi = weight / (height * height);
		double bfp = 0;
		String tinhtrangBFP = " ";
		if (gender.equals("male")) {
			bfp = 1.20 * bmi + 0.23 * age - 16.2;
			if (bfp >= 2 && bfp <= 5) {
				tinhtrangBFP = "Essential fat";
			}
			if (bfp >5 && bfp <= 13) {
				tinhtrangBFP = "Athletes ";
			}
			if (bfp >13 && bfp <= 17) {
				tinhtrangBFP = "Fitness";
			}
			if (bfp >17 && bfp <= 25) {
				tinhtrangBFP = "Average";
			}
			if (bfp >25) {
				tinhtrangBFP = "Obese";
			}
		} else if (gender.equals("female")) {
			bfp = 1.20 * bmi + 0.23 * age - 5.4;
			if (bfp >= 10 && bfp <= 13) {
				tinhtrangBFP = "Essential fat";
			}
			if (bfp >13 && bfp <= 20) {
				tinhtrangBFP = "Athletes ";
			}
			if (bfp >20  && bfp <= 24) {
				tinhtrangBFP = "Fitness";
			}
			if (bfp >24 && bfp <= 31) {
				tinhtrangBFP = "Average";
			}
			if (bfp >31) {
				tinhtrangBFP = "Obese";
			}
		}
		bfp =Double.parseDouble(new DecimalFormat("##.###").format(bfp)); 
		model.addAttribute("tinhtrangbfp", tinhtrangBFP);
		model.addAttribute("bfp", bfp);
		return "/user/result_bfp_caculate";
	}
	
	@PostMapping(value = "/bmr")
	public String CalBMR(HttpServletRequest request,
						@RequestParam(name = "age", required = true) double age,
						@RequestParam(name = "weight", required = true) double weight,
						@RequestParam(name = "height", required = true) double height,
						@RequestParam(name = "inlineRadioOptions", required = true) String gender,
						@RequestParam(name = "cuongdo", required = true) String cuongdo,
						Model model) {
		
		height = height / 100;
		double bmr = 0;
		double bfp = 0;
		double bmi = weight / (height * height);
		double tdee=0;
		if (gender.equals("male")) {
			bfp = 1.20 * bmi + 0.23 * age - 16.2;
		} else if (gender.equals("female")) {
			bfp = 1.20 * bmi + 0.23 * age - 5.4;
		}
		
		bmr = 21.6 * weight * (100 -bfp)/100;
		
		if(cuongdo.equals("it")) {
			tdee = bmr * 1.2;
		}else if(cuongdo.equals("nhe")) {
			tdee = bmr * 1.375;
		}else if(cuongdo.equals("vuaphai")) {
			tdee = bmr * 1.55;
		}else if(cuongdo.equals("nhieu")) {
			tdee = bmr * 1.725;
		}else if(cuongdo.equals("ratnhieu")) {
			tdee = bmr * 1.9;
		}
		bmr =Double.parseDouble(new DecimalFormat("##.##").format(bmr)); 
		tdee =Double.parseDouble(new DecimalFormat("##.##").format(tdee));
		
		model.addAttribute("BMR", bmr);
		model.addAttribute("tdee", tdee);
		
		return "/user/result_bmr_caculate";

	}
}
