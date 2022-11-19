package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface managerCakeService {

	public void ManagerCakeList(Model model, HttpServletRequest request) throws Exception;
}
