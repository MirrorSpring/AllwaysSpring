package com.allways.base.dao;

import org.apache.ibatis.session.SqlSession;

public class customerProfileDaoImpl implements customerProfileDao {

	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.customerProfileDao";
	
	@Override
	public int CustomerLogin(String customerId, String customerPw) throws Exception {
		return sqlSession.selectOne(nameSpace + ".CustomerLogin");
	}

	@Override
	public String CustomerGetName(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".CustomerGetName");
	}

}
