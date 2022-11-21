package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public interface managerGoodsService {
	public void ManagerViewGoodsList(HttpServletRequest request, Model model) throws Exception;
	public void ManagerAddGoods(MultipartHttpServletRequest request, Model model, MultipartFile file) throws Exception;
	public void ManagerCheckGoodsName(HttpServletRequest request, Model model) throws Exception;
	public void ManagerGoodsDetail(HttpServletRequest request, Model model) throws Exception;
	public void ManagerCheckGoodsName2(HttpServletRequest request, Model model) throws Exception;
	public void ManagerUpdateGoods(MultipartHttpServletRequest request, MultipartFile file) throws Exception;
	public void ManagerDeleteGoods(HttpServletRequest request) throws Exception;
}
