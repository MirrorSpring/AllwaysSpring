package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface customerBoardService {
	
	public void CustomerBoardList(HttpServletRequest request, Model model) throws Exception;
	public void CustomerWriteBoard(HttpServletRequest request) throws Exception;
	public void CustomerBoardDetail(HttpServletRequest request, Model model) throws Exception;
	public void CustomerWriteComment(HttpServletRequest request, Model model) throws Exception;
	public void CustomerDeleteBoard(HttpServletRequest request) throws Exception;

}
