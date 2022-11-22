package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerOptionDto;

public class managerOptionDaoImpl implements managerOptionDao {

	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerOptionDao";
	
	@Override
	public List<managerOptionDto> ManagerViewOptionList() throws Exception {
		System.out.println("success");
		return sqlSession.selectList(nameSpace + ".ManagerViewOptionList");
	}

	@Override
	public List<managerOptionDto> ManagerSearchOption(String condition, String query) throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerSearchOption");
	}

	@Override
	public int ManagerCheckOptionName(String optionValue, String cakeoptionCategory) throws Exception {
		return (int) sqlSession.selectOne(nameSpace + ".ManagerCheckOptionName");
	}

	@Override
	public void ManagerAddOption(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice,
			String cakeoptionImage) throws Exception {
		sqlSession.update(nameSpace + ".ManagerAddOption");
	}

	@Override
	public managerOptionDto ManagerOptionDetail(int cakeoptionId) throws Exception {
		return (managerOptionDto) sqlSession.selectOne(nameSpace + ".ManagerOptionDetail");
	}

	@Override
	public int ManagerCheckOptionName2(String optionValue, String cakeoptionCategory, int cakeoptionId) throws Exception {
		return (int) sqlSession.selectOne(nameSpace + ".ManagerCheckOptionName2");
	}

	@Override
	public void ManagerUpdateOption(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice,
			String cakeoptionImage, int cakeoptionId) throws Exception {
		sqlSession.update(nameSpace + ".ManagerUpdateOption");
	}

	@Override
	public void ManagerUpdateOption2(String cakeoptionCategory, String cakeoptionValue, String cakeoptionPrice, int cakeoptionId)
			throws Exception {
		sqlSession.update(nameSpace + ".ManagerUpdateOption2");
	}

	@Override
	public void ManagerDeleteOption(int cakeoptionId) throws Exception {
		sqlSession.update(nameSpace + ".ManagerDeleteOption");
	}

}
