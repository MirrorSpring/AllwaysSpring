package com.allways.base.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.allways.base.service.customerCakeService;
import com.allways.base.service.customerReviewService;

@Controller
public class customerController2 {
	
	@Autowired
	customerCakeService cakeservice;
	
	@Autowired
	customerReviewService reviewservice;
	
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
	
	@RequestMapping("/Customer/writereview")
	public String PrepareReview(HttpServletRequest request, Model model) throws Exception{
		reviewservice.PrepareReview(request, model);
		return "Customer/customerWriteReview";
	}
	
	@RequestMapping("/Customer/reviewwrite")
	public String WriteReview(MultipartHttpServletRequest request, @RequestParam("reviewImage") MultipartFile file) throws Exception{
		reviewservice.WriteReview(request, file);
		return "redirect:MyOrder";
	}
	
	@RequestMapping("/Customer/review")
	public String CustomerReviewList(HttpServletRequest request, Model model) throws Exception{
		reviewservice.ReviewList(request, model);
		return "Customer/customerOrderReview";
	}

}
