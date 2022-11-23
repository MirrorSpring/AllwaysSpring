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
	
	@RequestMapping("/Customer/location")
	public String CustomerLocation() throws Exception{
		return "Customer/customerLocation";
	}
	
	@RequestMapping("/Customer/cakeDetail")
	public String CustomerCakeDetail(HttpServletRequest request, Model model) throws Exception{
		cakeservice.CustomerCakeDetail(request, model);
		cakeservice.CustomerCakeOption(model, request);
		return "Customer/customerCakeDetail";
	}
	
	@RequestMapping("/Customer/addCart")
	public String CustomerAddCart(HttpServletRequest request) throws Exception{
		cakeservice.CustomerCakeCart(request);
		return "redirect:cart";
	}
	
	@RequestMapping("/Customer/cart")
	public String CustomerCart(HttpServletRequest request, Model model) throws Exception{
		cakeservice.GetCart(request, model);
		return "Customer/customerCart";
	}
	
	@RequestMapping("/Customer/deleteCart")
	public String DeleteCart(HttpServletRequest request) throws Exception{
		cakeservice.DeleteCart(request);
		return "redirect:cart";
	}
	
	@RequestMapping("/Customer/deleteCartList")
	public String DeleteCartList(HttpServletRequest request) throws Exception{
		cakeservice.DeleteCartList(request);
		return "redirect:cart";
	}
	
	@RequestMapping("/Customer/orderconfirm")
	public String CakeOrder(HttpServletRequest request, Model model) throws Exception{
		cakeservice.CakeOrderPage(request, model);
		return "Customer/customerOrder";
	}
	
	@RequestMapping("/Customer/order")
	public String OrderCake(HttpServletRequest request) throws Exception{
		cakeservice.OrderCake(request);
		return "redirect:home";
	}

}
