package com.allways.base.dao;

public interface customerProfileDao {

	public int CustomerLogin(String customerId, String customerPw) throws Exception;

	public String CustomerGetName(String customerId) throws Exception;

	public int CustomerCheckId(String customerId) throws Exception;

	public void CustomerJoin(String customerId, String customerPw, String customerName, String customerGender,
			String customerPhone, String customerEmail, String customerBirthday, String customerPostcode,
			String customerAddress, String customerAddressDetail) throws Exception;
}
