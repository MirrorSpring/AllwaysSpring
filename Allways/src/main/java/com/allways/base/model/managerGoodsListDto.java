package com.allways.base.model;

public class managerGoodsListDto {
	
	int goodsId;
	String goodsName;
	String goodsCategory;
	int goodsPrice;
	String goodsImage;
	String goodsDetail;
	
	public managerGoodsListDto(String goodsName, String goodsCategory, int goodsPrice, String goodsImage, String goodsDetail) {
		super();
		this.goodsName = goodsName;
		this.goodsCategory=goodsCategory;
		this.goodsPrice = goodsPrice;
		this.goodsImage = goodsImage;
		this.goodsDetail = goodsDetail;
	}
	
	public managerGoodsListDto(String goodsName, String goodsCategory, int goodsPrice, String goodsDetail) {
		super();
		this.goodsName = goodsName;
		this.goodsCategory = goodsCategory;
		this.goodsPrice = goodsPrice;
		this.goodsDetail = goodsDetail;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public managerGoodsListDto(int goodsId, String goodsName, String goodsCategory, int goodPrice) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsCategory = goodsCategory;
		this.goodsPrice = goodPrice;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodCategory) {
		this.goodsCategory = goodCategory;
	}

	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public String getGoodsDetail() {
		return goodsDetail;
	}
	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}
	

}
