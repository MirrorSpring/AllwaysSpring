package com.allways.base.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allways.base.service.customerProfileService;

@Controller
public class customerController {
	
	@Autowired
	customerProfileService profileservice;

	@RequestMapping("/Customer/login")
	public String CustomerLoginView() {
		return "Customer/customerLogin";
	}
	
	@RequestMapping("/Customer/loginTry")
	public String CustomerLoginTry(HttpServletRequest request, Model model) throws Exception{
		boolean check=profileservice.CustomerLogin(request, model);
		
		if (check==false) {
			return "Customer/customerLogin";
		} else {
			return "Customer/customerMain";
		}
	}
}
