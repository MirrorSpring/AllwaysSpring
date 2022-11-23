package com.allways.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.customerCakeDao;
import com.allways.base.model.customerCakeDto;

@Service
public class customerCakeServiceImpl implements customerCakeService {
	
	@Autowired
	customerCakeDao dao;
	
	public void CustomerCakeList(HttpServletRequest request, Model model) throws Exception{
		String sort1=request.getParameter("sort1");
		String sort2=request.getParameter("sort2");
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		
		if (request.getParameter("index")!=null) {
			if (request.getParameter("index").equals("")!=true) {
				index=(int)Float.parseFloat(request.getParameter("index"));
			}
		}
		
		if (index%pagecount==0) {
			pagepage=index/pagecount-1;
		} else {
			pagepage=index/pagecount;
		}
		
		if (sort1==null||sort1.equals("")==true) {
			sort1="cakeId";
		}
		
		if (sort2==null) {
			sort2="";
		}
		
		List<customerCakeDto> dtos=dao.CustomerCakeList(sort1, sort2);
		
		model.addAttribute("cakeList", dtos);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
	}

}
