package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerCakeDetailDto;
import com.allways.base.model.managerCakeListDto;

public class managerCakeDaoImpl implements managerCakeDao {
	
	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerCakeDao";

	@Override
	public List<managerCakeListDto> ManagerCakeList(String cakeName, int a, int b) throws Exception {
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

	@Override
	public managerCakeDetailDto ManagerViewCakeDetail(String cakeName) throws Exception {
		return (managerCakeDetailDto) sqlSession.selectList(nameSpace + ".ManagerViewCakeDetail");
	}

	@Override
	public void ManagerDeleteCake(String cakeName) throws Exception {
		sqlSession.update(nameSpace + ".ManagerDeleteCake");
	}

	@Override
	public void ManagerUpdateCake(String cakeName, int cakePrice, String cakeDetail, String cakeImage,
			String cakeOriginalName) throws Exception {
		sqlSession.update(nameSpace + ".ManagerUpdateCake");
	}

	@Override
	public void ManagerUpdateCake2(String cakeName, int cakePrice, String cakeDetail, String cakeOriginalName)
			throws Exception {
		sqlSession.update(nameSpace + ".ManagerUpdateCake2");
	}

	@Override
	public int ManagerCheckCakeName2(String cakeName, String cakeOriginalName) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManagerCheckCakeName2");
	}

	@Override
	public int CakeCount(String cakeName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(nameSpace + ".CakeCount");
	}

}
