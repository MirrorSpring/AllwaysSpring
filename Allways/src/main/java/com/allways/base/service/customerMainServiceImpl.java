package com.allways.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.customerMainDao;
import com.allways.base.model.customerCakeDto;

@Service
public class customerMainServiceImpl implements customerMainService {
	
	@Autowired
	customerMainDao dao;

	@Override
	public void CustomerBestCake(HttpServletRequest request,Model model) throws Exception {
		List<customerCakeDto> dtos=dao.CustomerBestCake();
		
		model.addAttribute("bestCakeList", dtos);
	}

}
