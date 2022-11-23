package com.allways.base.service;

import java.io.File;
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
}
