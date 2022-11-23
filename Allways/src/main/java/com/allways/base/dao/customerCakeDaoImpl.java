package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.customerCakeDto;
import com.allways.base.model.customercakeOptionDto;

public class customerCakeDaoImpl implements customerCakeDao {
	
	SqlSession sqlSession;
	String nameSpace="com.allways.base.dao.customerCakeDao";
	
	@Override
	public List<customerCakeDto> CustomerCakeList(String sort1, String sort2)
			throws Exception {
		return sqlSession.selectList(nameSpace + ".CustomerCakeList");
	}

	@Override
	public customerCakeDto CustomerCakeDetail(int cakeId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".CustomerCakeDetail");
	}

	@Override
	public List<customercakeOptionDto> CustomerCakeOption(String cakeoptionCategory) throws Exception {
		return sqlSession.selectOne(nameSpace + ".CustomerCakeOption");
	}

}
