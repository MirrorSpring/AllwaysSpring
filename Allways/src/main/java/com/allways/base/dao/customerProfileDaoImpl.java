package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.customerInfoDto;
import com.allways.base.model.customerOrdersDto;


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

	@Override
	public int CustomerCheckId(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".CustomerCheckId");
	}

	@Override
	public void CustomerJoin(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception {
		sqlSession.update(nameSpace + ".CustomerJoin");
	}

	@Override
	public customerInfoDto CustomerMypage(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".CustomerMypage");
	}

	@Override
	public void CustomerUpdate(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception {
		sqlSession.update(nameSpace + ".CustomerUpdate");
	}

	@Override
	public void CustomerDelete(String customerId) throws Exception {
		sqlSession.update(nameSpace + ".CustomerDelete");
	}

	@Override
	public List<customerOrdersDto> ViewMyOrder(String customerId) {
		return sqlSession.selectList(nameSpace + ".ViewMyOrder");
	}

}
