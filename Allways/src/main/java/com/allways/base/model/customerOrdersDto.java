package com.allways.base.model;

public class customerOrdersDto {

	int ordersId;
	String cakeName;
	int ordersQuantity;
	int ordersSalePrice;
	
	public customerOrdersDto() {
		
	}

	public customerOrdersDto(int ordersId, String cakeName, int ordersQuantity, int ordersSalePrice) {
		super();
		this.ordersId = ordersId;
		this.cakeName = cakeName;
		this.ordersQuantity = ordersQuantity;
		this.ordersSalePrice = ordersSalePrice;
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public int getOrdersQuantity() {
		return ordersQuantity;
	}

	public void setOrdersQuantity(int ordersQuantity) {
		this.ordersQuantity = ordersQuantity;
	}

	public int getOrdersSalePrice() {
		return ordersSalePrice;
	}

	public void setOrdersSalePrice(int ordersSalePrice) {
		this.ordersSalePrice = ordersSalePrice;
	}

}
