package com.allways.base.dao;

import org.apache.ibatis.session.SqlSession;

public class managerLoginDaoImpl implements managerLoginDao {

	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerLoginDao";
	
	@Override
	public int ManagerLogin(String managerId, String managerPw) throws Exception {
		int count=(int) sqlSession.selectOne(nameSpace + ".ManagerLogin");
		
		return count;
	}

}
