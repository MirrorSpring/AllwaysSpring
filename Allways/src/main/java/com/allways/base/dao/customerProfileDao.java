package com.allways.base.dao;

import java.util.List;

import com.allways.base.model.customerInfoDto;
import com.allways.base.model.customerOrdersDto;

public interface customerProfileDao {

	public int CustomerLogin(String customerId, String customerPw) throws Exception;

	public String CustomerGetName(String customerId) throws Exception;

	public int CustomerCheckId(String customerId) throws Exception;

	public void CustomerJoin(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception;
	
	public customerInfoDto CustomerMypage(String customerId) throws Exception;
	
	public void CustomerUpdate(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception;
	
	public void CustomerDelete(String customerId) throws Exception;
	
	public List<customerOrdersDto> ViewMyOrder(String customerId);
	
	public String FindID(String customerName, String customerBirthday, String customerPhone, String customerEmail) throws Exception;
	
	public int FindPw(String customerId, String customerName, String customerBirthday, String customerPhone, String customerEmail) throws Exception;
	
	public void ResetPw(String customerPw, String customerId) throws Exception;
}
