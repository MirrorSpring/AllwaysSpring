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

import com.allways.base.dao.managerOptionDao;
import com.allways.base.model.managerOptionDto;

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
			if (request.getParameter("index").equals("")==false)
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
			condition="cakeoptionId";
			query="";
		}
		int size=dao.SearchCount(condition, query);
		
		List<managerOptionDto> dto=dao.ManagerSearchOption(condition, "%" + query + "%", (index-1)*5,5);
		
		model.addAttribute("dto", dto);
		model.addAttribute("Size", size);
		
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
		model.addAttribute("condition", condition);
		model.addAttribute("query", query);
	}

	@Override
	public void ManagerCheckOptionName(HttpServletRequest request, Model model) throws Exception {
		String optionValue=request.getParameter("optionValue");
		String cakeoptionCategory=request.getParameter("cakeoptionCategory");
		String optionPrice=request.getParameter("optionPrice");
		int check=dao.ManagerCheckOptionName(optionValue, cakeoptionCategory);
		
		if (check==1) {
			model.addAttribute("check", true);
		} else {
			model.addAttribute("check", false);
		}
		
		model.addAttribute("optionValue", optionValue);
		model.addAttribute("cakeoptionCategory", cakeoptionCategory);
		model.addAttribute("optionPrice", optionPrice);
	}

	@Override
	public void ManagerAddOption(MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		String optionValue=request.getParameter("optionValue");
		String cakeoptionCategory=request.getParameter("cakeoptionCategory");
		String optionPrice=request.getParameter("optionPrice");
		
		String origName = file.getOriginalFilename();
		if (origName==null||origName.equals("")==true) {
			dao.ManagerAddOption(cakeoptionCategory, optionValue, optionPrice, null);
		} else {
			String uuid = UUID.randomUUID().toString();
			String extension = origName.substring(origName.lastIndexOf("."));
			String optionImage = uuid + extension;
			String savedPath = context.getRealPath("/") + "image/option/" + optionImage;
			file.transferTo(new File(savedPath));
			dao.ManagerAddOption(cakeoptionCategory, optionValue, optionPrice, optionImage);
		}
        
	}

	@Override
	public void ManagerOptionDetail(HttpServletRequest request, Model model) throws Exception {
		int cakeoptionId=Integer.parseInt(request.getParameter("cakeoptionId"));
		managerOptionDto dto=dao.ManagerOptionDetail(cakeoptionId);
		
		model.addAttribute("dto", dto);
	}

	@Override
	public void ManagerCheckOptionName2(HttpServletRequest request, Model model) throws Exception {
		int cakeoptionId=Integer.parseInt(request.getParameter("cakeoptionId"));
		String cakeoptionCategory=request.getParameter("cakeoptionCategory");
		String cakeoptionValue=request.getParameter("cakeoptionValue");
		int cakeoptionPrice=Integer.parseInt(request.getParameter("cakeoptionPrice"));
		
		System.out.println(cakeoptionValue);
		
		int check=dao.ManagerCheckOptionName2(cakeoptionValue, cakeoptionCategory, cakeoptionId);
		
		if (check==1) {
			model.addAttribute("check", true);
		} else {
			model.addAttribute("check", false);
		}
		
		managerOptionDto dto=new managerOptionDto(cakeoptionId, cakeoptionCategory, cakeoptionValue, cakeoptionPrice);
		model.addAttribute("dto", dto);
	}

	@Override
	public void ManagerUpdateOption(MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		String optionValue=request.getParameter("cakeoptionValue");
		String cakeoptionCategory=request.getParameter("cakeoptionCategory");
		String optionPrice=request.getParameter("cakeoptionPrice");
		int optionId=Integer.parseInt(request.getParameter("cakeoptionId"));
		
		String origName = file.getOriginalFilename();
		
		if (origName!=null&&origName.equals("")!=true) {
			String uuid = UUID.randomUUID().toString();
			String extension = origName.substring(origName.lastIndexOf("."));
			String optionImage = uuid + extension;
			String savedPath = context.getRealPath("/") + "WEB-INF/views/Manager/image/option/" + optionImage;
			file.transferTo(new File(savedPath));
			dao.ManagerUpdateOption(cakeoptionCategory, optionValue, optionPrice, optionImage, optionId);
		} else {
			dao.ManagerUpdateOption2(cakeoptionCategory, optionValue, optionPrice, optionId);
		}
        
	}

	@Override
	public void ManagerDeleteOption(HttpServletRequest request) throws Exception {
		int cakeoptionId=Integer.parseInt(request.getParameter("cakeoptionId"));
		
		dao.ManagerDeleteOption(cakeoptionId);
	}

}
