package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface managerOrdersService {
	
	public void ManagerViewOrders(Model model) throws Exception;
	public void ManagerOrdersDetail(HttpServletRequest request, Model model) throws Exception;
	public void ManagerAlterStatus(HttpServletRequest request) throws Exception;
	public void ManagerDeleteOrder(HttpServletRequest request) throws Exception;

}
