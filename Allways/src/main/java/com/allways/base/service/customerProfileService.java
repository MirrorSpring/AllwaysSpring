package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface customerProfileService {

	public boolean CustomerLogin(HttpServletRequest request, Model model) throws Exception;
}