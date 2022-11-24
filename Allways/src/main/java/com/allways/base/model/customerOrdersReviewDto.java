package com.allways.base.model;

import java.sql.Timestamp;

public class customerOrdersReviewDto {

	int rownum;
	String or_customerId;
	String oreviewContent;
	Timestamp oreviewInitdate;
	String oreviewImage;
	int oreviewStarrating;
	int or_cakeId;
	
	public customerOrdersReviewDto() {
		
	}

	public customerOrdersReviewDto(int rownum, String or_customerId, String oreviewContent, Timestamp oreviewInitdate) {
		super();
		this.rownum = rownum;
		this.or_customerId = or_customerId;
		this.oreviewContent = oreviewContent;
		this.oreviewInitdate = oreviewInitdate;
	}

	public customerOrdersReviewDto(int rownum, String or_customerId, String oreviewContent, Timestamp oreviewInitdate,
			String oreviewImage, int oreviewStarrating, int or_cakeId) {
		super();
		this.rownum = rownum;
		this.or_customerId = or_customerId;
		this.oreviewContent = oreviewContent;
		this.oreviewInitdate = oreviewInitdate;
		this.oreviewImage = oreviewImage;
		this.oreviewStarrating = oreviewStarrating;
		this.or_cakeId = or_cakeId;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getOr_customerId() {
		return or_customerId;
	}

	public void setOr_customerId(String or_customerId) {
		this.or_customerId = or_customerId;
	}

	public String getOreviewContent() {
		return oreviewContent;
	}

	public void setOreviewContent(String oreviewContent) {
		this.oreviewContent = oreviewContent;
	}

	public Timestamp getOreviewInitdate() {
		return oreviewInitdate;
	}

	public void setOreviewInitdate(Timestamp oreviewInitdate) {
		this.oreviewInitdate = oreviewInitdate;
	}

	public String getOreviewImage() {
		return oreviewImage;
	}

	public void setOreviewImage(String oreviewImage) {
		this.oreviewImage = oreviewImage;
	}

	public int getOreviewStarrating() {
		return oreviewStarrating;
	}

	public void setOreviewStarrating(int oreviewStarrating) {
		this.oreviewStarrating = oreviewStarrating;
	}

	public int getOr_cakeId() {
		return or_cakeId;
	}

	public void setOr_cakeId(int or_cakeId) {
		this.or_cakeId = or_cakeId;
	}

}
