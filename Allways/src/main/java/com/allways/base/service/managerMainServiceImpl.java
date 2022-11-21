package com.allways.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.allways.base.dao.managerMainDao;
import com.allways.base.model.managerMainOrdersDto;

@Service
public class managerMainServiceImpl implements managerMainService {
	
	@Autowired
	managerMainDao dao;

	@Override
	public void ManagerMain(Model model) throws Exception {
		// TODO Auto-generated method stub
		List<managerMainOrdersDto> dtos=dao.ManagerMainOrder();
		List<String> arrxaxis=dao.ManagerMakeXaxis();
		List<Integer> arrsales=dao.ManagerMakeSale();
		List<Integer> arrquantity=dao.ManagerMakeQuantity();
		String xaxis="";
		String sales="";
		String quantity="";
		
		for (int i=0;i<=arrxaxis.size()-1;i++) {
			xaxis+=arrxaxis.get(i);
			if (i<arrxaxis.size()-1) {
				xaxis+=",";
			}
		}
		
		for (int i=0;i<=arrsales.size()-1;i++) {
			sales+=arrsales.get(i);
			if(i<arrsales.size()-1) {
				sales+=",";
			}
		}
		
		for (int i=0;i<=arrquantity.size()-1;i++) {
			quantity+=arrquantity.get(i);
			if (i<arrquantity.size()-1) {
				quantity+=",";
			}
		}
		
		model.addAttribute("ORDERS", dtos);
		model.addAttribute("XAXIS",xaxis);
		model.addAttribute("SALESPRICE", sales);
		model.addAttribute("SALESQUANTITY",quantity);
	}

}
