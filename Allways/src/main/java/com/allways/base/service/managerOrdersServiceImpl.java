package com.allways.base.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.managerOrdersDao;
import com.allways.base.model.managerOrdersDto;

@Service
public class managerOrdersServiceImpl implements managerOrdersService {
	
	@Autowired
	managerOrdersDao dao;

	@Override
	public void ManagerViewOrders(Model model) throws Exception {
		
		List<managerOrdersDto> dto1=dao.ManagerViewOrders1();
		List<managerOrdersDto> dto2=dao.ManagerViewOrders2();
		List<managerOrdersDto> dto3=dao.ManagerViewOrders3();
		
		model.addAttribute("dto", dto1);
		model.addAttribute("dto2", dto2);
		model.addAttribute("dto3", dto3);
		
	}

	@Override
	public void ManagerOrdersDetail(HttpServletRequest request, Model model) throws Exception {
		int ordersId=Integer.parseInt(request.getParameter("ordersId"));
		String ordersStatus=request.getParameter("ordersStatus");
		
		managerOrdersDto dto=dao.ManagerOrdersDetail(ordersId, ordersStatus);
		
		model.addAttribute("dto", dto);
	}

	@Override
	public void ManagerAlterStatus(HttpServletRequest request) throws Exception {
		int ordersId=Integer.parseInt(request.getParameter("ordersId"));
		String ordersStatus=request.getParameter("ordersStatus");
		String o_customerId=request.getParameter("o_customerId");
		int o_cakeId=Integer.parseInt(request.getParameter("o_cakeId"));
		int o_goodsId=Integer.parseInt(request.getParameter("o_goodsId"));
		int ordersSalePrice=Integer.parseInt(request.getParameter("ordersSalePrice"));
		int ordersQuantity=Integer.parseInt(request.getParameter("ordersQuantity"));
		
		if (ordersStatus.equals("구매")) {
			dao.ManagerAddStatus(ordersId, o_customerId, o_cakeId, o_goodsId, ordersSalePrice, ordersQuantity);
			dao.ManagerAlterStatus(ordersId);
		} else if(ordersStatus.equals("제작중")) {
			dao.ManagerAddStatus2(ordersId, o_customerId, o_cakeId, o_goodsId, ordersSalePrice, ordersQuantity);
			dao.ManagerAlterStatus2(ordersId);
		}
	}

	@Override
	public void ManagerDeleteOrder(HttpServletRequest request) throws Exception {
		int ordersId=Integer.parseInt(request.getParameter("ordersId"));
		
		dao.ManagerDeleteOrder(ordersId);
	}

}
