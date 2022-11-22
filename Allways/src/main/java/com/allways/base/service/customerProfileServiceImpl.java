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
		session.setAttribute("Name", dao.CustomerGetName(customerId));
		session.setAttribute("customerId", customerId);
		return true;
	}

}
