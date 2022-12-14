package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface customerCakeService {

	public void CustomerCakeList(HttpServletRequest request, Model model) throws Exception;
	public void CustomerCakeDetail(HttpServletRequest request, Model model) throws Exception;
	public void CustomerCakeOption(Model model, HttpServletRequest request) throws Exception;
	public void CustomerCakeCart(HttpServletRequest request) throws Exception;
	public void GetCart(HttpServletRequest request, Model model) throws Exception;
	public void DeleteCart(HttpServletRequest request) throws Exception;
	public void DeleteCartList(HttpServletRequest request) throws Exception;
	public void CakeOrderPage(HttpServletRequest request, Model model) throws Exception;
	public void OrderCake(HttpServletRequest request) throws Exception;
}
