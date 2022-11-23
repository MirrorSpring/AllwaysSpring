package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface customerProfileService {

	public boolean CustomerLogin(HttpServletRequest request, Model model) throws Exception;
	public void CustomerCheckId(HttpServletRequest request, Model model) throws Exception;
	public void CustomerJoin(HttpServletRequest request) throws Exception;
	public void CustomerLogout(HttpServletRequest request) throws Exception;
	public void CustomerMypage(HttpServletRequest request, Model model) throws Exception;
	public void CustomerUpdate(HttpServletRequest request) throws Exception;
	public void CustomerDelete(HttpServletRequest request) throws Exception;
	public void CustomerViewMyOrder(HttpServletRequest request, Model model);
}
