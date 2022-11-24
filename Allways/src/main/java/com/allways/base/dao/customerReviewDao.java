package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.customerOrdersReviewDto;

public interface customerReviewDao {
	
	public void WriteReview(String or_customerId, int or_ordersId, String oreviewContent, int oreviewStarRating, String oreviewImage, int or_cakeId) throws Exception;
	public List<customerOrdersReviewDto> ReviewList(String condition, String query, String sort) throws Exception;
	
}
