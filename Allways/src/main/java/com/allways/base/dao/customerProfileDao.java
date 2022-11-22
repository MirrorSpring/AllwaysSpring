package com.allways.base.dao;

public interface customerProfileDao {

	public int CustomerLogin(String customerId, String customerPw) throws Exception;
	public String CustomerGetName(String customerId) throws Exception;
}
