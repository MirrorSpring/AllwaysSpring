package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.managerLoginDao;

@Service
public class managerLoginServiceImpl implements managerLoginService {
	
	@Autowired
	managerLoginDao dao;

	@Override
	public int ManagerLogin(HttpServletRequest request, Model model) throws Exception {
		String managerId=request.getParameter("managerId");
		String managerPw=request.getParameter("managerPw");
		
		int check=dao.ManagerLogin(managerId, managerPw);
		
		if (check==1) {
			model.addAttribute("CHECK", true);
		} else {
			model.addAttribute("CHECK", false);
		}
		return check;
	}

}
