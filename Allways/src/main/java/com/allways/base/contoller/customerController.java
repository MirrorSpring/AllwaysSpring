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
	
	@RequestMapping("/Customer/join")
	public String CustomerJoin() throws Exception{
		return "Customer/customerJoin";
	}
	
	@RequestMapping("/Customer/idCheck")
	public String CustomerIdCheck(HttpServletRequest request, Model model) throws Exception{
		profileservice.CustomerCheckId(request, model);
		return "Customer/customerJoin";
	}
	
	@RequestMapping("/Customer/CustomerJoin")
	public String Join(HttpServletRequest request) throws Exception{
		profileservice.CustomerJoin(request);
		return "redirect:login";
	}
}
