package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.managerOrdersDto;

public interface managerOrdersDao {
	
	public List<managerOrdersDto> ManagerViewOrders1() throws Exception;
	public List<managerOrdersDto> ManagerViewOrders2() throws Exception;
	public List<managerOrdersDto> ManagerViewOrders3() throws Exception;
	public managerOrdersDto ManagerOrdersDetail(int ordersId, String ordersStatus) throws Exception;
	public void ManagerAddStatus(int ordersId, String o_customerId, int o_cakeId, int o_goodsId, int ordersSalePrice, int ordersQuantity) throws Exception;
	public void ManagerAlterStatus(int ordersId) throws Exception;
	public void ManagerAddStatus2(int ordersId, String o_customerId, int o_cakeId, int o_goodsId, int ordersSalePrice, int ordersQuantity) throws Exception;
	public void ManagerAlterStatus2(int ordersId) throws Exception;
	public void ManagerDeleteOrder(int ordersId) throws Exception;
}
