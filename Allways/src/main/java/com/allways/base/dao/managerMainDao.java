package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.ManagerMainOrdersReviewDto;
import com.allways.base.model.managerMainOrdersDto;

public interface managerMainDao {

	public List<managerMainOrdersDto> ManagerMainOrder() throws Exception;
	public List<String> ManagerMakeXaxis() throws Exception;
	public List<Integer> ManagerMakeSale() throws Exception;
	public List<Integer> ManagerMakeQuantity() throws Exception;
	public List<ManagerMainOrdersReviewDto> ManagerMainReview() throws Exception;
}
