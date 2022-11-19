package com.allways.base.model;

import java.sql.Timestamp;

public class ManagerMainOrdersReviewDto {

	Timestamp oreviewInitdate;
	String or_customerId;
	int oreviewStarrating;
	
	public ManagerMainOrdersReviewDto() {
		
	}
	
	public ManagerMainOrdersReviewDto(Timestamp oreviewInitdate, String or_customerId, int oreviewStarrating) {
		super();
		this.oreviewInitdate = oreviewInitdate;
		this.or_customerId = or_customerId;
		this.oreviewStarrating = oreviewStarrating;
	}

	public Timestamp getOreviewInitdate() {
		return oreviewInitdate;
	}
	public void setOreviewInitdate(Timestamp oreviewInitdate) {
		this.oreviewInitdate = oreviewInitdate;
	}
	public String getOr_customerId() {
		return or_customerId;
	}
	public void setOr_customerId(String or_customerId) {
		this.or_customerId = or_customerId;
	}
	public int getOreviewStarrating() {
		return oreviewStarrating;
	}
	public void setOreviewStarrating(int oreviewStarrating) {
		this.oreviewStarrating = oreviewStarrating;
	}
	
	
}
