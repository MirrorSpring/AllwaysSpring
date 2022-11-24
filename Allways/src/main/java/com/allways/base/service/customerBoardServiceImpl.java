package com.allways.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.customerBoardDao;
import com.allways.base.model.customerBoardDto;

@Service
public class customerBoardServiceImpl implements customerBoardService {
	
	@Autowired
	customerBoardDao dao;

	@Override
	public void CustomerBoardList(HttpServletRequest request, Model model) throws Exception {
		String condition=request.getParameter("combo");
		String query=request.getParameter("searchContent");
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // 몇 페이지부터 몇 페이지까지 출력할지

		int maxpage = (0 % rowcount) != 0 ? (0 / rowcount) + 1 : (0 / rowcount);

		if (request.getParameter("index") != null) {
			index = (int) Float.parseFloat(request.getParameter("index"));
		}

		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}
		
		if (condition==null||condition.equals("")==true) {
			condition="writeTitle";
		}
		
		if (query==null) {
			query="";
		}
		
		List<customerBoardDto> dto=dao.BoardList(condition, "%" + query + "%");
		
		model.addAttribute("writeList", dto);
		model.addAttribute("arrsize", dto.size());
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
	}

	@Override
	public void CustomerWriteBoard(HttpServletRequest request) throws Exception {
		HttpSession session=request.getSession();
		String w_customerId=(String) session.getAttribute("ID");
		String writeTitle=request.getParameter("writeTitle");
		String writeContent=request.getParameter("writeContent");
		
		int commentId=dao.WriteId();
		
		dao.WriteBoard(w_customerId, commentId+1, writeTitle, writeContent);
	}

	@Override
	public void CustomerBoardDetail(HttpServletRequest request, Model model) throws Exception {
		int writeId=Integer.parseInt(request.getParameter("writeId"));
		customerBoardDto dto=dao.BoardDetail(writeId);
		List<customerBoardDto> dto2=dao.BoardComment(writeId);
		
		model.addAttribute("boardDetail", dto);
		model.addAttribute("boardComment", dto2);
		model.addAttribute("boardlength", dto2.size());
	}

	@Override
	public void CustomerWriteComment(HttpServletRequest request, Model model) throws Exception {
		HttpSession session=request.getSession();
		String customerId=(String) session.getAttribute("ID");
		int commentId=Integer.parseInt(request.getParameter("writeId"));
		String writeContent=request.getParameter("writeContent");

		
		dao.WriteComment(customerId, commentId, writeContent);
		model.addAttribute("writeId", commentId);

	}

	@Override
	public void CustomerDeleteBoard(HttpServletRequest request) throws Exception {
		int writeId=Integer.parseInt(request.getParameter("writeId"));
		dao.DeleteBoard(writeId);
	}
	

}
