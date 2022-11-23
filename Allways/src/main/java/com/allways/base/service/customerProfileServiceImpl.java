package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.customerProfileDao;

@Service
public class customerProfileServiceImpl implements customerProfileService {
	
	@Autowired
	customerProfileDao dao;

	@Override
	public boolean CustomerLogin(HttpServletRequest request, Model model) throws Exception {
		HttpSession session=request.getSession();
		String customerId=request.getParameter("customerId");
		String customerPw=request.getParameter("customerPw");
		int check=dao.CustomerLogin(customerId, customerPw);
		
		if(check==0) {
			model.addAttribute("CHECK", false);
			return false;
		}
		session.setAttribute("NAME", dao.CustomerGetName(customerId));
		session.setAttribute("ID", customerId);
		return true;
	}

	@Override
	public void CustomerCheckId(HttpServletRequest request, Model model) throws Exception {
		String customerId=request.getParameter("customerId");
		String customerName=request.getParameter("customerName");
		String customerPhone=request.getParameter("customerPhone");
		String customerEmail=request.getParameter("email1");
		String customerBirth=request.getParameter("customerBirth");
		int check=dao.CustomerCheckId(customerId);
		
		if (check==1) {
			model.addAttribute("CHECK", true);
		} else {
			model.addAttribute("CHECK", false);
		}
		
		model.addAttribute("CHECKID", customerId);
		model.addAttribute("NAME", customerName);
		model.addAttribute("PHONE", customerPhone);
		model.addAttribute("BIRTH", customerBirth);
		model.addAttribute("EMAIL", customerEmail);
	}

	@Override
	public void CustomerJoin(HttpServletRequest request) throws Exception {
		String customerId=request.getParameter("customerId");
		String customerPw=request.getParameter("customerPw");
		String customerName=request.getParameter("customerName");
		String customerPhone=request.getParameter("customerPhone");
		String customerGender=request.getParameter("customerGender");
		String customerEmail=request.getParameter("email1") + "@" + request.getParameter("email2");
		String customerBirth=request.getParameter("customerBirth");
		String customerAddress=request.getParameter("address");
		String customerAddressDetail=request.getParameter("addressDetail");
		String customerPostCode=request.getParameter("postcode");
		
		dao.CustomerJoin(customerId, customerPw, customerName, customerGender, customerPhone, customerEmail, customerBirth, customerPostCode, customerAddress, customerAddressDetail);
		
	}

}
