package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.customerCakeDto;
import com.allways.base.model.customerInfoDto;
import com.allways.base.model.customerOrdersDto;
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

	@Override
	public void CustomerAddCart(String ordersStatus, String o_customerId, int o_cakeId, int ordersSalePrice, int ordersQuantity)
			throws Exception {
		sqlSession.insert(nameSpace + ".CustomerAddCart");
	}

	@Override
	public int GetOrdersId(String ordersStatus, String o_customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".GetOrdersId");
	}

	@Override
	public void CustomerAddDetailOption(int d_ordersId, int d_cakeoptionId, String d_customerId,
			int d_cakeId, int d_goodsId, String detailoptionLettering, String detailoptionPickupDate) throws Exception {
		sqlSession.insert(nameSpace + ".CustomerAddDetailOption");
	}

	@Override
	public int GetOptionPrice(String ordersStatus, int ordersId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".GetOptionPrice");
	}

	@Override
	public void UpdateSalesPrice(int ordersSalePrice, int ordersId) throws Exception {
		sqlSession.update(nameSpace + ".UpdateSalesPrice");
	}

	@Override
	public customerInfoDto GetCustomerInfo(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".GetCustomerInfo");
	}

	@Override
	public List<customerOrdersDto> GetCart(String customerId) throws Exception {
		return sqlSession.selectOne(nameSpace + ".GetCart");
	}

}
