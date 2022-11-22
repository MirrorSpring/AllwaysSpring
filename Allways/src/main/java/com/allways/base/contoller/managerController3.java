package com.allways.base.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.allways.base.service.managerOrdersService;

@Controller
public class managerController3 {

	@Autowired
	managerOrdersService ordersservice;
	
	@RequestMapping("/Manager/orders")
	public String ManagerOrders(Model model) throws Exception{
		ordersservice.ManagerViewOrders(model);
		return "Manager/ManagerOrderStatus";
	}
	
	@RequestMapping("/Manager/ordersDetail")
	public String ManagerOrdersDetail(HttpServletRequest request, Model model) throws Exception{
		ordersservice.ManagerOrdersDetail(request, model);
		return "Manager/ManagerAddStatus";
	}
	
	@RequestMapping("/Manager/alterStatus")
	public String ManagerAlterStatus(HttpServletRequest request) throws Exception{
		ordersservice.ManagerAlterStatus(request);
		return "redirect:orders";
	}
	
	@RequestMapping("/Manager/deleteOrder")
	public String ManagerDeleteOrder(HttpServletRequest request) throws Exception{
		ordersservice.ManagerDeleteOrder(request);
		return "redirect:orders";
	}
}
