package com.allways.base.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public interface customerReviewService {

	public void WriteReview(MultipartHttpServletRequest request, MultipartFile file) throws Exception;
	public void PrepareReview(HttpServletRequest request, Model model) throws Exception;
}
