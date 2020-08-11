package com.capstone.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserEstimateController {
	@RequestMapping(value = "/estimate", method = RequestMethod.GET)
    public String ResetPass(Model model) {       
        return "user/estimatedCalories";
    }
}
