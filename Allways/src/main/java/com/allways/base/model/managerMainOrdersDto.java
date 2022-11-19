package com.allways.base.model;

public class managerMainOrdersDto {

	int ordersId;
	String cakeName;
	String o_customerId;

	public managerMainOrdersDto(int ordersId, String o_customerId, String cakeName) {
		super();
		this.ordersId = ordersId;
		this.o_customerId = o_customerId;
		this.cakeName = cakeName;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public String getO_customerId() {
		return o_customerId;
	}

	public void setO_customerId(String o_customerId) {
		this.o_customerId = o_customerId;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}
	
}
