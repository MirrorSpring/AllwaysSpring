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

	@Override
	public void ManagerAddCake(String cakeName, int cakePrice, String cakeImage, String cakeDetail) throws Exception {
		sqlSession.insert(nameSpace + ".ManagerAddCake");
		
	}

	@Override
	public int ManagerCheckCakeName(String cakeName) throws Exception {
		return (int)sqlSession.selectOne(nameSpace + ".ManagerCheckCakeName");
	}

}
