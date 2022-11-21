package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerMainOrdersReviewDto;
import com.allways.base.model.managerMainOrdersDto;

public class managerMainDaoImpl implements managerMainDao {
	
	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerMainDao";

	@Override
	public List<managerMainOrdersDto> ManagerMainOrder() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(nameSpace + ".ManagerMainOrder");
	}

	@Override
	public List<String> ManagerMakeXaxis() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerMakeXaxis");
	}

	@Override
	public List<Integer> ManagerMakeSale() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerMakeSale");
	}

	@Override
	public List<Integer> ManagerMakeQuantity() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerMakePrice");
	}

	@Override
	public List<managerMainOrdersReviewDto> ManagerMainReview() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerMainReview");
	}

}
