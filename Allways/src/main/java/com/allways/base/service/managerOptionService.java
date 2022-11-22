package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public interface managerOptionService {

	public void ManagerViewOptionList(HttpServletRequest request, Model model) throws Exception;
	public void ManagerCheckOptionName(HttpServletRequest request, Model model) throws Exception;
	public void ManagerAddOption(MultipartHttpServletRequest request, MultipartFile file) throws Exception;
	public void ManagerOptionDetail(HttpServletRequest request, Model model) throws Exception;
	public void ManagerCheckOptionName2(HttpServletRequest request, Model model) throws Exception;
	public void ManagerUpdateOption(MultipartHttpServletRequest request, MultipartFile file) throws Exception;
	public void ManagerDeleteOption(HttpServletRequest request) throws Exception;
}
