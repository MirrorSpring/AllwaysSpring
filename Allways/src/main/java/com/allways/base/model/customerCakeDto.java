package com.allways.base.model;

public class customerCakeDto {

	int cakeId;
	String cakeName;
	int cakePrice;
	String cakeImage;
	int cakeLike;
	int cakeViews;
	
	public customerCakeDto() {
		
	}

	public customerCakeDto(int cakeId, String cakeName, int cakePrice, String cakeImage) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeImage = cakeImage;
	}

	public customerCakeDto(int cakeId, String cakeName, int cakePrice, String cakeImage, int cakeLike, int cakeViews) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakePrice = cakePrice;
		this.cakeImage = cakeImage;
		this.cakeLike = cakeLike;
		this.cakeViews = cakeViews;
	}

	public int getCakeLike() {
		return cakeLike;
	}

	public void setCakeLike(int cakeLike) {
		this.cakeLike = cakeLike;
	}

	public int getCakeViews() {
		return cakeViews;
	}

	public void setCakeViews(int cakeViews) {
		this.cakeViews = cakeViews;
	}

	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public int getCakePrice() {
		return cakePrice;
	}

	public void setCakePrice(int cakePrice) {
		this.cakePrice = cakePrice;
	}

	public String getCakeImage() {
		return cakeImage;
	}

	public void setCakeImage(String cakeImage) {
		this.cakeImage = cakeImage;
	}

}
