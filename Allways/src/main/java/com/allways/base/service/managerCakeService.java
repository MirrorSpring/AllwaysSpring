package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public interface managerCakeService {

	public void ManagerCakeList(Model model, HttpServletRequest request) throws Exception;
	public void ManagerAddCake(MultipartHttpServletRequest request, Model model, MultipartFile file) throws Exception;
	public void ManagerCheckCakeName(Model model, HttpServletRequest request) throws Exception;
	public void ManagerViewCakeDetail(Model model, HttpServletRequest reuqest) throws Exception;
	public void ManagerDeleteCake(HttpServletRequest request) throws Exception;
	public void ManagerUpdateCake(MultipartHttpServletRequest request, MultipartFile file) throws Exception;
	public void ManagerCheckCakeName2(MultipartHttpServletRequest request, Model model) throws Exception;
}
