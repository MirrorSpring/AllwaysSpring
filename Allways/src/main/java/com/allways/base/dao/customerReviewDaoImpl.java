package com.allways.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerReviewDaoImpl implements customerReviewDao {
	
	SqlSession sqlSession;
	String nameSpace="com.allways.base.dao.customerReviewDao";

	@Override
	public void WriteReview(String or_customerId, int or_ordersId, String oreviewContent, int oreviewStarRating,
			String oreviewImage, int or_cakeId) throws Exception {
		sqlSession.insert(nameSpace + ".WriteReview");
	}

}
