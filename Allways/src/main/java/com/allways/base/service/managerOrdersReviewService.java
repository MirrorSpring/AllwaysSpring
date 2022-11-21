package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface managerOrdersReviewService {

	public void ManagerViewOrdersReviewList(Model model, HttpServletRequest request) throws Exception;
	public void ManagerOrdersReviewDetail(Model model, HttpServletRequest request) throws Exception;
}
