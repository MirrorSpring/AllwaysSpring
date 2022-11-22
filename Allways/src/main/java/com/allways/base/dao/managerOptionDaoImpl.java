package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerOptionDto;

public class managerOptionDaoImpl implements managerOptionDao {

	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerOptionDao";
	
	@Override
	public List<managerOptionDto> ManagerViewOptionList() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerViewOptionList");
	}

	@Override
	public List<managerOptionDto> ManagerSearchOption(String condition, String query) throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerSearchOption");
	}

}
