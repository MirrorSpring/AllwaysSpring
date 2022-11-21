package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerMainOrdersReviewDto;
import com.allways.base.model.managerMainOrdersDto;

public interface managerMainDao {

	public List<managerMainOrdersDto> ManagerMainOrder() throws Exception;
	public List<String> ManagerMakeXaxis() throws Exception;
	public List<Integer> ManagerMakeSale() throws Exception;
	public List<Integer> ManagerMakeQuantity() throws Exception;
	public List<managerMainOrdersReviewDto> ManagerMainReview() throws Exception;
}
