package com.allways.base.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.allways.base.model.managerOrdersDto;

public class managerOrdersDaoImpl implements managerOrdersDao {
	
	SqlSession sqlSession;
	public static String nameSpace="com.allways.base.dao.managerOrdersDao";
	
	@Override
	public List<managerOrdersDto> ManagerViewOrders1() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerViewOrders1");
	}

	@Override
	public List<managerOrdersDto> ManagerViewOrders2() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerViewOrders2");
	}

	@Override
	public List<managerOrdersDto> ManagerViewOrders3() throws Exception {
		return sqlSession.selectList(nameSpace + ".ManagerViewOrders3");
	}

	@Override
	public managerOrdersDto ManagerOrdersDetail(int ordersId, String ordersStatus) throws Exception {
		return sqlSession.selectOne(nameSpace + ".ManagerOrdersDetail");
	}

	@Override
	public void ManagerAddStatus(int ordersId, String o_customerId, int o_cakeId, int o_goodsId,
			int ordersSalePrice, int ordersQuantity, int ordersPoint) throws Exception {
		sqlSession.insert(nameSpace + ".ManagerAddStatus");
	}

	@Override
	public void ManagerAlterStatus(int ordersId) throws Exception {
		sqlSession.update(nameSpace + ".ManagerAlterStatus");
	}

	@Override
	public void ManagerAddStatus2(int ordersId, String o_customerId, int o_cakeId, int o_goodsId, int ordersSalePrice,
			int ordersQuantity, int ordersPoint) throws Exception {
		sqlSession.insert(nameSpace + ".ManagerAddStatus2");
	}

	@Override
	public void ManagerAlterStatus2(int ordersId) throws Exception {
		sqlSession.update(nameSpace + ".ManagerAlterStatus2");
	}

	@Override
	public void ManagerDeleteOrder(int ordersId) throws Exception {
		sqlSession.update(nameSpace + ".ManagerDeleteOrder");
	}

}
