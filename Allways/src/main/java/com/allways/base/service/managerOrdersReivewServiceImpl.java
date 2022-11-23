package com.allways.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.managerReviewDao;
import com.allways.base.model.managerOrdersReviewDto;

@Service
public class managerOrdersReivewServiceImpl implements managerOrdersReviewService {
	
	@Autowired
	managerReviewDao dao;

	@Override
	public void ManagerViewOrdersReviewList(Model model, HttpServletRequest request) throws Exception {
		int index=1;
		int rowcount=7;
		int pagecount=5;
		int pagepage=0;
		String query=request.getParameter("query");
		String condition=request.getParameter("condition");
		
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
		
		if (query==null) {
			query="";
		}
		
		List<managerOrdersReviewDto> dtos=dao.ManagerViewOrdersReviewList();
		
		if (condition!=null&&condition.equals("")==false) {
			dtos=dao.ManagerSearchOrdersReview(condition, "%" + query + "%");
		} else {
			dtos=dao.ManagerViewOrdersReviewList();
		}
		
		model.addAttribute("Dtos", dtos);
		model.addAttribute("condition", condition);
		model.addAttribute("query", query);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		
	}

	@Override
	public void ManagerOrdersReviewDetail(Model model, HttpServletRequest request) throws Exception {
		int oreviewId=Integer.parseInt(request.getParameter("oreviewId"));
		
		managerOrdersReviewDto dto=dao.ManagerOrdersReviewDetail(oreviewId);
		
		model.addAttribute("DTO", dto);
	}

}
