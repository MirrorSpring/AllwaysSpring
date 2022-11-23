package com.allways.base.dao;

public interface customerReviewDao {
	
	public void WriteReview(String or_customerId, int or_ordersId, String oreviewContent, int oreviewStarRating, String oreviewImage, int or_cakeId) throws Exception;

}
