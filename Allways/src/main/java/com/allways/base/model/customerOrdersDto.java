package com.allways.base.model;

public class customerOrdersDto {

	int rownum;
	int ordersId;
	int cakeId;
	String cakeName;
	String o_customerId;
	int ordersSalePrice;
	int ordersQuantity;
	String ordersDate;
	int o_cakeId;
	
	public customerOrdersDto() {
		
	}

	public customerOrdersDto(int ordersId, String cakeName, int ordersQuantity, int ordersSalePrice) {
		super();
		this.ordersId = ordersId;
		this.cakeName = cakeName;
		this.ordersQuantity = ordersQuantity;
		this.ordersSalePrice = ordersSalePrice;
	}

	public customerOrdersDto(int cakeId, int ordersId, String cakeName, int ordersQuantity, int ordersSalePrice) {
		super();
		this.cakeId = cakeId;
		this.ordersId = ordersId;
		this.cakeName = cakeName;
		this.ordersQuantity = ordersQuantity;
		this.ordersSalePrice = ordersSalePrice;
	}
	
	public customerOrdersDto(int rownum, int ordersId, String cakeName, String o_customerId, int ordersSalePrice,
			int ordersQuantity, String ordersDate, int o_cakeId) {
		super();
		this.rownum = rownum;
		this.ordersId = ordersId;
		this.cakeName = cakeName;
		this.o_customerId = o_customerId;
		this.ordersSalePrice = ordersSalePrice;
		this.ordersQuantity = ordersQuantity;
		this.ordersDate = ordersDate;
		this.o_cakeId = o_cakeId;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getO_customerId() {
		return o_customerId;
	}

	public void setO_customerId(String o_customerId) {
		this.o_customerId = o_customerId;
	}

	public String getOrdersDate() {
		return ordersDate;
	}

	public void setOrdersDate(String ordersDate) {
		this.ordersDate = ordersDate;
	}

	public int getO_cakeId() {
		return o_cakeId;
	}

	public void setO_cakeId(int o_cakeId) {
		this.o_cakeId = o_cakeId;
	}

	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
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
