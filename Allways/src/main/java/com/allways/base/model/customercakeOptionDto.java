package com.allways.base.model;

public class customercakeOptionDto {

	int cakeoptionId;
	String cakeoptionCategory;
	String cakeoptionValue;
	int cakeoptionPrice;
	
	public customercakeOptionDto() {
		
	}

	public customercakeOptionDto(int cakeoptionId, String cakeoptionCategory, String cakeoptionValue,
			int cakeoptionPrice) {
		super();
		this.cakeoptionId = cakeoptionId;
		this.cakeoptionCategory = cakeoptionCategory;
		this.cakeoptionValue = cakeoptionValue;
		this.cakeoptionPrice = cakeoptionPrice;
	}

	public int getCakeoptionId() {
		return cakeoptionId;
	}

	public void setCakeoptionId(int cakeoptionId) {
		this.cakeoptionId = cakeoptionId;
	}

	public String getCakeoptionCategory() {
		return cakeoptionCategory;
	}

	public void setCakeoptionCategory(String cakeoptionCategory) {
		this.cakeoptionCategory = cakeoptionCategory;
	}

	public String getCakeoptionValue() {
		return cakeoptionValue;
	}

	public void setCakeoptionValue(String cakeoptionValue) {
		this.cakeoptionValue = cakeoptionValue;
	}

	public int getCakeoptionPrice() {
		return cakeoptionPrice;
	}

	public void setCakeoptionPrice(int cakeoptionPrice) {
		this.cakeoptionPrice = cakeoptionPrice;
	}

}
