package com.allways.base.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allways.base.service.ManagerMainService;
import com.allways.base.service.managerCakeService;
import com.allways.base.service.managerLoginService;

@Controller
public class managerController {
	
	@Autowired
	ManagerMainService mainservice;
	
	@Autowired
	managerLoginService loginservice;
	
	@Autowired
	managerCakeService cakeservice;

	@RequestMapping("/Manager/login")
	public String login() throws Exception{
		return "Manager/managerLogin";
	}
	
	@RequestMapping("Manager/logintry")
	public String logintry(HttpServletRequest request, Model model) throws Exception{
		int check=loginservice.ManagerLogin(request, model);
		if (check==1) {
			return "redirect:home";
		} else {
			return "Manager/managerLogin";
		}
	}
	
	@RequestMapping("/Manager/home")
	public String Main(Model model) throws Exception{
		mainservice.ManagerMain(model);
		return "Manager/managermain";
	}
	
	@RequestMapping("/Manager/cake")
	public String ManagerCakeList(Model model, HttpServletRequest request) throws Exception{
		cakeservice.ManagerCakeList(model, request);
		return "Manager/managerviewmenu";
	}
	
}
