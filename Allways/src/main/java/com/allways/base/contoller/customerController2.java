package com.allways.base.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allways.base.service.customerCakeService;

@Controller
public class customerController2 {
	
	@Autowired
	customerCakeService cakeservice;
	
	@RequestMapping("/Customer/cake")
	public String Customercake(HttpServletRequest request, Model model) throws Exception{
		cakeservice.CustomerCakeList(request, model);
		return "Customer/customerCakeList";
	}

}
