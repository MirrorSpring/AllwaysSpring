package com.allways.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.customerCakeDao;
import com.allways.base.model.customerCakeDto;
import com.allways.base.model.customercakeOptionDto;

@Service
public class customerCakeServiceImpl implements customerCakeService {

	@Autowired
	customerCakeDao dao;

	public void CustomerCakeList(HttpServletRequest request, Model model) throws Exception {
		String sort1 = request.getParameter("sort1");
		String sort2 = request.getParameter("sort2");
		int index = 1;
		int rowcount = 7;
		int pagecount = 5;
		int pagepage = 0;

		if (request.getParameter("index") != null) {
			if (request.getParameter("index").equals("") != true) {
				index = (int) Float.parseFloat(request.getParameter("index"));
			}
		}

		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;
		}

		if (sort1 == null || sort1.equals("") == true) {
			sort1 = "cakeId";
		}

		if (sort2 == null) {
			sort2 = "";
		}

		List<customerCakeDto> dtos = dao.CustomerCakeList(sort1, sort2);

		model.addAttribute("cakeList", dtos);
		model.addAttribute("Size", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
	}

	@Override
	public void CustomerCakeDetail(HttpServletRequest request, Model model) throws Exception {
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		customerCakeDto dto = dao.CustomerCakeDetail(cakeId);

		model.addAttribute("cakeInfo", dto);
	}

	@Override
	public void CustomerCakeOption(Model model, HttpServletRequest request) throws Exception {
		List<customercakeOptionDto> size = dao.CustomerCakeOption("Size");
		List<customercakeOptionDto> shape = dao.CustomerCakeOption("Shape");
		List<customercakeOptionDto> flavor = dao.CustomerCakeOption("Flavor");
		int index = 1; // 시작 페이지 번호
		int rowcount = 10; // 한 페이지에 출력할 리스트 개수
		int pagecount = 10; // 한 페이지에 출력할 페이지 개수
		int pagepage = 0; // ??

		int maxpage = (0 % rowcount) != 0 ? (0 / rowcount) + 1 : (0 / rowcount);

		if (request.getParameter("index") != null) {
			index = (int) Float.parseFloat(request.getParameter("index"));
		}

		if (index % pagecount == 0) {
			pagepage = index / pagecount - 1;
		} else {
			pagepage = index / pagecount;

			model.addAttribute("shapeList", shape);
			model.addAttribute("sizeList", size);
			model.addAttribute("flavorList", flavor);

			request.setAttribute("maxpage", maxpage);
			request.setAttribute("index", index);
			request.setAttribute("rowcount", rowcount);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("pagepage", pagepage);
		}
	}

}
