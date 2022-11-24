package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.customerInfoDto;
import com.allways.base.model.customerOrdersDto;
import com.allways.base.model.customerPointDto;


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

	@Override
	public String FindID(String customerName, String customerBirthday, String customerPhone, String customerEmail)
			throws Exception {
		return sqlSession.selectOne(nameSpace + ".FindID");
	}

	@Override
	public int FindPw(String customerId, String customerName, String customerBirthday, String customerPhone,
			String customerEmail) throws Exception {
		return sqlSession.selectOne(nameSpace + ".FindPw");
	}

	@Override
	public void ResetPw(String customerPw, String customerId) throws Exception {
		sqlSession.update(nameSpace + ".ResetPw");
	}

	@Override
	public List<customerPointDto> MyPoint(String customerId) throws Exception {
		
		return sqlSession.selectList(nameSpace + ".MyPoint");
	}

	@Override
	public int TotalPoint(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".TotalPoint");
	}

}
