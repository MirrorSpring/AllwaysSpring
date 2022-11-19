package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerCakeListDto;

public class managerCakeDaoImpl implements managerCakeDao {
	
	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerCakeDao";

	@Override
	public List<managerCakeListDto> ManagerCakeList(String cakeName) throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerCakeList");
	}

}
