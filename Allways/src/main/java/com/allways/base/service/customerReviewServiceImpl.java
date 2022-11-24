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

import com.allways.base.dao.customerReviewDao;
import com.allways.base.model.customerOrdersReviewDto;

@Service
public class customerReviewServiceImpl implements customerReviewService {

	@Autowired
	customerReviewDao dao;

	@Override
	public void WriteReview(MultipartHttpServletRequest request, MultipartFile file) throws Exception {
		HttpSession session=request.getSession();
		ServletContext context=session.getServletContext();
		String or_customerId=(String) session.getAttribute("ID");
		int or_ordersId=Integer.parseInt(request.getParameter("ordersId"));
		int or_cakeId=Integer.parseInt(request.getParameter("o_cakeId"));
		int oreviewStarrating=Integer.parseInt(request.getParameter("oreviewStarRating"));
		String oreviewContent=request.getParameter("oreviewContent");
		
        String origName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = origName.substring(origName.lastIndexOf("."));
        String oreviewImage = uuid + extension;
        String savedPath = context.getRealPath("/") + "image/review/" + oreviewImage;
        file.transferTo(new File(savedPath));
        
        dao.WriteReview(or_customerId, or_ordersId, oreviewContent, oreviewStarrating, oreviewImage, or_cakeId);
	}

	@Override
	public void PrepareReview(HttpServletRequest request, Model model) throws Exception {
		String ordersId=request.getParameter("ordersId");
		String o_cakeId=request.getParameter("o_cakeId");
		
		model.addAttribute("ordersId", ordersId);
		model.addAttribute("o_cakeId", o_cakeId);
	}

	@Override
	public void ReviewList(HttpServletRequest request, Model model) throws Exception {
		String condition=request.getParameter("combo");
		String query=request.getParameter("searchContent");
		String sort=request.getParameter("sort");
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
		
		if (condition==null||condition.equals("")) {
			condition="or_customerId";
		}
		
		if (query==null) {
			query="";
		}
		
		if (sort==null||sort.equals("")) {
			sort="rownum";
		}
		
		List<customerOrdersReviewDto> dto=dao.ReviewList(condition, query, query);
		
		model.addAttribute("reviewList", dto);
		model.addAttribute("arrsize", dto.size());
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
	}
}
