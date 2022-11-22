package com.allways.base.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.allways.base.dao.managerGoodsDao;
import com.allways.base.model.managerGoodsListDto;

@Service
public class managerGoodsServiceImpl implements managerGoodsService {
	
	@Autowired
	managerGoodsDao dao;

	@Override
	public void ManagerViewGoodsList(HttpServletRequest request, Model model) throws Exception {
		String goodsCategory=request.getParameter("goodsCategory");
		String goodsName=request.getParameter("query");
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		
		if (goodsName==null) {
			goodsName="";
		}
		
		if (goodsCategory==null||goodsCategory.equals("")) {
			goodsCategory="all";
		}

		List<managerGoodsListDto> dtos=dao.ManagerViewAllGoods("%" + goodsName + "%");
		
		if (goodsCategory.equals("all")) {
			dtos=dao.ManagerViewAllGoods("%" + goodsName + "%");
		} else {
			dtos=dao.ManagerViewGoodsList(goodsCategory, "%" + goodsName + "%");
		}
		
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index%pagecount==0) {
			pagepage=index/pagecount-1;
		} else {
			pagepage=index/pagecount;
		}
		
		
		
		model.addAttribute("Dtos", dtos);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("Query", goodsName);
		model.addAttribute("goodsCategory", goodsCategory);
		
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
	}

	@Override
	public void ManagerAddGoods(MultipartHttpServletRequest request, Model model, MultipartFile file) throws Exception {
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		
		String goodsName=request.getParameter("goodsName");
		String goodsCategory=request.getParameter("goodsCategory");
		int goodsPrice=Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsDetail=request.getParameter("goodsDetail");
		
		
		String origName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = origName.substring(origName.lastIndexOf("."));
        String goodsImage = uuid + extension;
        String savedPath = context.getRealPath("/") + "WEB-INF/views/Manager/image/goods/" + goodsImage;
        file.transferTo(new File(savedPath));
        
        dao.ManagerAddGoods(goodsName, goodsCategory, goodsPrice, goodsDetail, goodsImage);
	}

	@Override
	public void ManagerCheckGoodsName(HttpServletRequest request, Model model) throws Exception {
		String goodsName=request.getParameter("goodsName");
		String goodsCategory=request.getParameter("goodsCategory");
		String goodsPrice=request.getParameter("goodsPrice");
		String goodsDetail=request.getParameter("goodsDetail");
		
		int check=dao.ManagerCheckGoodsName(goodsName);
		
		if (check==1) {
			model.addAttribute("check", false);
		} else {
			model.addAttribute("check", true);
		}
		
		model.addAttribute("goodsName", goodsName);
		model.addAttribute("goodsCategory", goodsCategory);
		model.addAttribute("goodsPrice", goodsPrice);
		model.addAttribute("goodsDetail", goodsDetail);
	}

	@Override
	public void ManagerGoodsDetail(HttpServletRequest request, Model model) throws Exception {
		String goodsName=request.getParameter("goodsName");
		managerGoodsListDto dto=dao.ManagerGoodsDetail(goodsName);
		
		model.addAttribute("dto", dto);
		model.addAttribute("goodsOriginalName", goodsName);
	}

	@Override
	public void ManagerCheckGoodsName2(HttpServletRequest request, Model model) throws Exception {
		String goodsName=request.getParameter("goodsName");
		String goodsOriginalName=request.getParameter("goodsOriginalName");
		String goodsCategory=request.getParameter("goodsCategory");
		int goodsPrice=Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsDetail=request.getParameter("goodsDetail");
		managerGoodsListDto dto=new managerGoodsListDto(goodsName, goodsCategory, goodsPrice, goodsDetail);
		
		int check=dao.ManagerCheckGoodsName2(goodsName, goodsOriginalName);
		
		if (check==1) {
			model.addAttribute("check", false);
		} else {
			model.addAttribute("check", true);
		}
		model.addAttribute("dto", dto);
		model.addAttribute("goodsOriginalName", goodsOriginalName);
	}

	@Override
	public void ManagerUpdateGoods(MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		
		String goodsName=request.getParameter("goodsName");
		int goodsPrice=Integer.parseInt(request.getParameter("goodsPrice"));
		String goodsCategory=request.getParameter("goodsCategory");
		String goodsDetail=request.getParameter("goodsDetail");
		String goodsOriginalName=request.getParameter("goodsOriginalName");
		
		String origName = file.getOriginalFilename();
		
		if (origName!=null&&origName.equals("")!=true) {
			String uuid = UUID.randomUUID().toString();
			String extension = origName.substring(origName.lastIndexOf("."));
			String goodsImage = uuid + extension;
			String savedPath = context.getRealPath("/") + "WEB-INF/views/Manager/image/goods/" + goodsImage;
			file.transferTo(new File(savedPath));
			dao.ManagerUpdateGoods(goodsName, goodsCategory, goodsPrice, goodsDetail, goodsImage, goodsOriginalName);
		} else {
			dao.ManagerUpdateGoods2(goodsName, goodsCategory, goodsPrice, goodsDetail, goodsOriginalName);
		}
	}

	@Override
	public void ManagerDeleteGoods(HttpServletRequest request) throws Exception {
		String goodsOriginalName=request.getParameter("goodsOriginalName");
		dao.ManagerDeleteGoods(goodsOriginalName);
	}

}
