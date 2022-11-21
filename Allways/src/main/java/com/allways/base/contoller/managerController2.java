package com.allways.base.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.allways.base.service.managerGoodsService;

@Controller
public class managerController2 {

	@Autowired
	managerGoodsService goodsservice;
	
	@RequestMapping("/Manager/goods")
	public String ManagerViewGoods(HttpServletRequest request, Model model) throws Exception{
		goodsservice.ManagerViewGoodsList(request, model);
		return "Manager/managerviewgoods";
	}
	
	@RequestMapping("/Manager/addgoodsview")
	public String ManagerAddGoodsView() {
		return "Manager/managercreategoods";
	}
	
	@RequestMapping("/Manager/checkGoodsName")
	public String ManagerCheckGoodsName(HttpServletRequest request, Model model) throws Exception{
		goodsservice.ManagerCheckGoodsName(request, model);
		return "Manager/managercreategoods";
	}
	
	@RequestMapping("/Manager/addGoods")
	public String ManagerAddGoods(MultipartHttpServletRequest request, @RequestParam("goodsImage") MultipartFile file, Model model) throws Exception{
		goodsservice.ManagerAddGoods(request, model, file);
		return "redirect:goods";
	}
	
}
