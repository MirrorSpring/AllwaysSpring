package com.allways.base.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.customerCakeDao;
import com.allways.base.model.customerCakeDto;
import com.allways.base.model.customerInfoDto;
import com.allways.base.model.customerOrdersDto;
import com.allways.base.model.customerOrdersReviewDto;
import com.allways.base.model.customercakeOptionDto;

@Service
public class customerCakeServiceImpl implements customerCakeService {

	@Autowired
	customerCakeDao dao;

	public void CustomerCakeList(HttpServletRequest request, Model model) throws Exception {
		String sort1 = request.getParameter("sort1");
		String sort2 = request.getParameter("sort2");
		int index = 1;
		int rowcount = 8;
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
		model.addAttribute("arrsize", dtos.size());
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);
	}

	@Override
	public void CustomerCakeDetail(HttpServletRequest request, Model model) throws Exception {
		
	}

	@Override
	public void CustomerCakeOption(Model model, HttpServletRequest request) throws Exception {
		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		customerCakeDto dto = dao.CustomerCakeDetail(cakeId);
		List<customerOrdersReviewDto> rdto=dao.ShowReview(cakeId);

		List<customercakeOptionDto> size = dao.CustomerCakeOption("Size");
		List<customercakeOptionDto> shape = dao.CustomerCakeOption("Shape");
		List<customercakeOptionDto> flavor = dao.CustomerCakeOption("Flavor");
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
		
		model.addAttribute("shapeList", shape);
		model.addAttribute("sizeList", size);
		model.addAttribute("flavorList", flavor);
		model.addAttribute("cakeInfo", dto);
		model.addAttribute("reviewList", rdto);
		model.addAttribute("Size", rdto.size());
		
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("index", index);
		model.addAttribute("rowcount", rowcount);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("pagepage", pagepage);

	}

	@Override
	public void CustomerCakeCart(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("ID");

		int cakeId = Integer.parseInt(request.getParameter("cakeId"));
		int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
		int ordersQuantity = Integer.parseInt(request.getParameter("ordersQuantity"));
		int shape = Integer.parseInt(request.getParameter("shape"));
		int size = Integer.parseInt(request.getParameter("size"));
		int flavor = Integer.parseInt(request.getParameter("flavor"));
		int[] option = { shape, size, flavor };
		String detailoptionLettering = request.getParameter("detailoptionLettering");
		String detailoptionPickupDate = request.getParameter("detailoptionPickupDate");

		dao.CustomerAddCart("장바구니", customerId, cakeId, cakePrice, ordersQuantity);

		int ordersId = dao.GetOrdersId("장바구니", customerId);

		for (int i = 0; i < option.length; i++) {
			dao.CustomerAddDetailOption(ordersId, option[i], customerId, cakeId, ordersId, detailoptionLettering,
					detailoptionPickupDate);
		}

		int price = dao.GetOptionPrice("장바구니", ordersId);
		dao.UpdateSalesPrice((cakePrice + price) * ordersQuantity, ordersId);

	}

	@Override
	public void GetCart(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("ID");
		List<customerOrdersDto> dto = dao.GetCart(customerId);

		model.addAttribute("cartList", dto);
	}

	@Override
	public void DeleteCart(HttpServletRequest request) throws Exception {
		int ordersId = Integer.parseInt(request.getParameter("ordersId"));
		dao.DeleteCart(ordersId);
	}

	@Override
	public void DeleteCartList(HttpServletRequest request) throws Exception {
		String[] strordersId = request.getParameterValues("ordersId");

		for (int i = 0; i < strordersId.length; i++) {
			dao.DeleteCart(Integer.parseInt(strordersId[i]));
		}
	}

	@Override
	public void CakeOrderPage(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute("ID");
		String[] strordersId = request.getParameterValues("ordersId");
		List<customerOrdersDto> dtos = new ArrayList<customerOrdersDto>();
		customerInfoDto cdto = dao.GetCustomerInfo(customerId);

		for (int i = 0; i < strordersId.length; i++) {
			customerOrdersDto dto = dao.GetSelectedOrder(customerId, Integer.parseInt(strordersId[i]));
			dtos.add(dto);
		}

		model.addAttribute("orderList", dtos);
		model.addAttribute("dto", cdto);
	}

	@Override
	public void OrderCake(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		String customerId = (String) session.getAttribute("ID");

		String[] ordersId = request.getParameterValues("ordersId");
		String[] cakeId = request.getParameterValues("cakeId");
		String[] ordersSalePrice = request.getParameterValues("ordersSalePrice");
		String[] ordersQuantity = request.getParameterValues("ordersQuantity");

		for (int i = 0; i < ordersId.length; i++) {
			dao.OrderCake(Integer.parseInt(ordersId[i]), "구매", customerId, Integer.parseInt(cakeId[i]),
					Integer.parseInt(ordersSalePrice[i]), Integer.parseInt(ordersQuantity[i]),
					Integer.parseInt(ordersSalePrice[i]) / 10);
			dao.addPoint(Integer.parseInt(ordersSalePrice[i]) / 10, Integer.parseInt(ordersId[i]));
			dao.addPoint2(Integer.parseInt(ordersId[i]));
		}
	}

}
