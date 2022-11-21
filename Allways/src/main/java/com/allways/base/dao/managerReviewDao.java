package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerOrdersReviewDto;

public interface managerReviewDao {

	public List<managerOrdersReviewDto> ManagerViewOrdersReviewList() throws Exception;
	public List<managerOrdersReviewDto> ManagerSearchOrdersReview(String condition, String query) throws Exception;
	public managerOrdersReviewDto ManagerOrdersReviewDetail(int oreviewId) throws Exception;
}
