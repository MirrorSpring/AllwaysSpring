package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerOrdersReviewDto;

public class managerReviewDaoImpl implements managerReviewDao {
	
	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerOrdersReviewDao";

	@Override
	public List<managerOrdersReviewDto> ManagerViewOrdersReviewList() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerViewOrdersReviewList");
	}

	@Override
	public List<managerOrdersReviewDto> ManagerSearchOrdersReview(String condition, String query) throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerSearchOrdersReview");
	}

	@Override
	public managerOrdersReviewDto ManagerOrdersReviewDetail(int oreviewId) throws Exception {
		return (managerOrdersReviewDto) sqlSession.selectOne(nameSpace + ".ManagerOrdersReviewDetail");
	}

}
