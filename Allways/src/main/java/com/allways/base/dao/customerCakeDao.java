package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.customerCakeDto;
import com.allways.base.model.customerInfoDto;
import com.allways.base.model.customerOrdersDto;
import com.allways.base.model.customercakeOptionDto;

public interface customerCakeDao {
	
	public List<customerCakeDto> CustomerCakeList(String sort1, String sort2) throws Exception;
	public customerCakeDto CustomerCakeDetail(int cakeId) throws Exception;
	public List<customercakeOptionDto> CustomerCakeOption(String cakeoptionCategory) throws Exception;
	public void CustomerAddCart(String ordersStatus, String o_customerId, int o_cakeId, int ordersSalePrice, int ordersQuantity) throws Exception;
	public int GetOrdersId(String ordersStatus, String o_customerId) throws Exception;
	public void CustomerAddDetailOption(int d_ordersId, int d_cakeoptionId, String d_customerId, int d_cakeId, int d_goodsId, String detailoptionLettering, String detailoptionPickupDate) throws Exception;
	public int GetOptionPrice(String ordersStatus, int ordersId) throws Exception;
	public void UpdateSalesPrice(int ordersSalePrice, int ordersId) throws Exception;
	public customerInfoDto GetCustomerInfo(String customerId) throws Exception;
	public List<customerOrdersDto> GetCart(String customerId) throws Exception;
	public void DeleteCart(int ordersId) throws Exception;
	public customerOrdersDto GetSelectedOrder(String customerId, int ordersId) throws Exception;
	public void OrderCake(int ordersId, String ordersStatus, String o_customerId, int o_cakeId, int ordersSalePrice, int ordersQuantity, int ordersPoint) throws Exception;
	
}
