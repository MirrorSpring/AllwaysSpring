package com.allways.base.model;

import java.sql.Timestamp;

/**
 * @author dbtmd
 *
 */
public class customerBoardDto {

	int rownum;
	String customerName;
	String writeContent;
	Timestamp writeInitdate;
	String w_customerId;
	int distinguish;
	int recommentId;
	
	public customerBoardDto(int rownum, String customerName, String writeContent, Timestamp writeInitdate,
			String w_customerId, int distinguish, int recommentId, Timestamp writeDeletedate, int writeId) {
		super();
		this.rownum = rownum;
		this.customerName = customerName;
		this.writeContent = writeContent;
		this.writeInitdate = writeInitdate;
		this.w_customerId = w_customerId;
		this.distinguish = distinguish;
		this.recommentId = recommentId;
		this.writeDeletedate = writeDeletedate;
		this.writeId = writeId;
	}

	Timestamp writeDeletedate;
	int writeId;
	String writeTitle;
	int commentId;

	
	public customerBoardDto() {

	}

	public int getRecommentId() {
		return recommentId;
	}

	public void setRecommentId(int recommentId) {
		this.recommentId = recommentId;
	}

	public customerBoardDto(int writeId, String customerName, String writeTitle, String writeContent,
			Timestamp writeInitdate) {
		super();
		this.writeId = writeId;
		this.customerName = customerName;
		this.writeTitle = writeTitle;
		this.writeContent = writeContent;
		this.writeInitdate = writeInitdate;
	}

	public customerBoardDto(int rownum, String writeTitle, String writeContent, String w_customerId,
			Timestamp writeInitdate, int distinguish, int writeId, Timestamp writeDeletedate, int commentId) {
		super();
		this.rownum = rownum;
		this.writeTitle = writeTitle;
		this.writeContent = writeContent;
		this.w_customerId = w_customerId;
		this.writeInitdate = writeInitdate;
		this.distinguish = distinguish;
		this.writeId = writeId;
		this.writeDeletedate = writeDeletedate;
		this.commentId = commentId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getWriteTitle() {
		return writeTitle;
	}

	public void setWriteTitle(String writeTitle) {
		this.writeTitle = writeTitle;
	}

	public String getWriteContent() {
		return writeContent;
	}

	public void setWriteContent(String writeContent) {
		this.writeContent = writeContent;
	}

	public String getW_customerId() {
		return w_customerId;
	}

	public void setW_customerId(String w_customerId) {
		this.w_customerId = w_customerId;
	}

	public Timestamp getWriteInitdate() {
		return writeInitdate;
	}

	public void setWriteInitdate(Timestamp writeInitdate) {
		this.writeInitdate = writeInitdate;
	}

	public int getDistinguish() {
		return distinguish;
	}

	public void setDistinguish(int distinguish) {
		this.distinguish = distinguish;
	}

	public int getWriteId() {
		return writeId;
	}

	public void setWriteId(int writeId) {
		this.writeId = writeId;
	}

	public Timestamp getWriteDeletedate() {
		return writeDeletedate;
	}

	public void setWriteDeletedate(Timestamp writeDeletedate) {
		this.writeDeletedate = writeDeletedate;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

}
