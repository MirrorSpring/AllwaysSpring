package com.allways.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
		
		cakeName="%" + cakeName + "%";
		
		List<managerCakeListDto> dtos=dao.ManagerCakeList(cakeName);
		
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

}
