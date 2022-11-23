package com.allways.base.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allways.base.service.customerMainService;
import com.allways.base.service.customerProfileService;

@Controller
public class customerController {
	
	@Autowired
	customerProfileService profileservice;
	
	@Autowired
	customerMainService mainservice;

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
			return "redirect:home";
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
	
	@RequestMapping("/Customer/home")
	public String CustomerMain(HttpServletRequest request,Model model) throws Exception{
		mainservice.CustomerBestCake(request, model);
		return "Customer/customerMain";
	}
	
	@RequestMapping("/Customer/logout")
	public String CustomerLogout(HttpServletRequest requst) throws Exception{
		profileservice.CustomerLogout(requst);
		return "redirect:home";
	}
	
	@RequestMapping("/Customer/myPage")
	public String CustomerMyPage(HttpServletRequest request, Model model) throws Exception{
		return "Customer/customerMypage";
	}
	
	@RequestMapping("/Customer/updateInfo")
	public String CustomerUpdateInfo(HttpServletRequest request, Model model) throws Exception{
		profileservice.CustomerMypage(request, model);
		return "Customer/customerMypageRevision";
	}
	
	@RequestMapping("/Customer/updateInfoAction")
	public String CustomerUpdate(HttpServletRequest request) throws Exception{
		profileservice.CustomerUpdate(request);
		return "redirect:home";
	}
	
	@RequestMapping("/Customer/delete")
	public String CustomerDelete(HttpServletRequest request) throws Exception{
		profileservice.CustomerDelete(request);
		return "redirect:home";
	}
}
