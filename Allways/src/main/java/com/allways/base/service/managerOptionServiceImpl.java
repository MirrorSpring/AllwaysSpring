package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.managerOptionDao;

@Service
public class managerOptionServiceImpl implements managerOptionService {
	
	@Autowired
	managerOptionDao dao;

	@Override
	public void ManagerViewOptionList(HttpServletRequest request, Model model) throws Exception {
		String condition=request.getParameter("condition");
		String query=request.getParameter("query");
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		
		if (request.getParameter("index")!=null) {
			index=(int)Float.parseFloat(request.getParameter("index"));
		}
		
		if (index%pagecount==0) {
			pagepage=index/pagecount-1;
		} else {
			pagepage=index/pagecount;
		}
		
		if (query==null) {
			query="";
		}
		
		if (condition==null||condition.equals("")) {
			model.addAttribute("dto", dao.ManagerViewOptionList());
			model.addAttribute("Size", dao.ManagerViewOptionList().size());
		} else {
			model.addAttribute("dto", dao.ManagerSearchOption(condition, "%" + query + "%"));
			model.addAttribute("Size", dao.ManagerSearchOption(condition, "%" + query + "%").size());
		}
		
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		model.addAttribute("condition", condition);
		model.addAttribute("query", query);
	}

}
