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

import com.allways.base.dao.managerCakeDao;
import com.allways.base.model.managerCakeListDto;

@Service
public class managerCakeServiceImpl implements managerCakeService {
	
	@Autowired
	managerCakeDao dao;

	@Override
	public void ManagerCakeList(Model model, HttpServletRequest request) throws Exception {
		String cakeName=request.getParameter("query");
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (cakeName==null) {
			cakeName="";
		}
		
		List<managerCakeListDto> dtos=dao.ManagerCakeList("%" + cakeName + "%");
		
		if (index%pagecount==0) {
			pagepage=index/pagecount-1;
		} else {
			pagepage=index/pagecount;
		}
		
		model.addAttribute("Dtos", dtos);
		model.addAttribute("Query", cakeName);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
	}

	@Override
	public void ManagerAddCake(MultipartHttpServletRequest request, Model model, MultipartFile file) throws Exception {
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		String cakeName=request.getParameter("cakeName");
		int cakePrice=Integer.parseInt(request.getParameter("cakePrice"));
		String cakeDetail=request.getParameter("cakeDetail");
		
        String origName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = origName.substring(origName.lastIndexOf("."));
        String cakeImage = uuid + extension;
        String savedPath = context.getRealPath("/") + cakeImage;
        
        dao.ManagerAddCake(cakeName, cakePrice, cakeImage, cakeDetail);
        model.addAttribute("cakeName", cakeName);
        model.addAttribute("cakePrice", cakePrice);
        model.addAttribute("cakeDetail", cakeDetail);
        
        file.transferTo(new File(savedPath));
	}

	@Override
	public void ManagerCheckCakeName(Model model, HttpServletRequest request) throws Exception {
		String cakeName=request.getParameter("cakeName");
		String cakePrice=request.getParameter("cakePrice");
		String cakeDetail=request.getParameter("cakeDetail");
		
		int check=dao.ManagerCheckCakeName(cakeName);
		
		model.addAttribute("cakeName", cakeName);
		model.addAttribute("cakePrice", cakePrice);
		model.addAttribute("cakeDetail", cakeDetail);
		
		if (check==1) {
			model.addAttribute("check", false);
		} else {
			model.addAttribute("check", true);
		}
	}

}
