package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.customerCakeDto;

public class customerMainDaoImpl implements customerMainDao {
	
	SqlSession sqlSession;
	String nameSpace="com.allways.base.dao.customerMainDao";
	
	@Override
	public List<customerCakeDto> CustomerBestCake() throws Exception {
		return sqlSession.selectList(nameSpace + ".CustomerBestCake");
	}

}
