package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.customerOrdersReviewDto;

public class customerReviewDaoImpl implements customerReviewDao {
	
	SqlSession sqlSession;
	String nameSpace="com.allways.base.dao.customerReviewDao";

	@Override
	public void WriteReview(String or_customerId, int or_ordersId, String oreviewContent, int oreviewStarRating,
			String oreviewImage, int or_cakeId) throws Exception {
		sqlSession.insert(nameSpace + ".WriteReview");
	}

	@Override
	public List<customerOrdersReviewDto> ReviewList(String condition, String query, String sort) throws Exception {
		return sqlSession.selectList(nameSpace + ".ReviewList");
	}

}
