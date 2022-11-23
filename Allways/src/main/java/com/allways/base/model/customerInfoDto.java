package com.allways.base.model;

public class customerInfoDto {

	String customerPw;
	String customerName;
	String customerGender;
	String customerPhone;
	String customerBirthday;
	String customerEmail;
	String customerPostcode;
	String customerAddress;
	String customerAddressDetail;

	public customerInfoDto() {

	}
	
	public customerInfoDto(String customerPw, String customerName, String customerGender, String customerPhone,
			String customerBirthday, String customerEmail, String customerPostcode, String customerAddress,
			String customerAddressDetail) {
		super();
		this.customerPw = customerPw;
		this.customerName = customerName;
		this.customerGender = customerGender;
		this.customerPhone = customerPhone;
		this.customerBirthday = customerBirthday;
		this.customerEmail = customerEmail;
		this.customerPostcode = customerPostcode;
		this.customerAddress = customerAddress;
		this.customerAddressDetail = customerAddressDetail;
	}

	public customerInfoDto(String customerName, String customerPhone, String customerEmail, String customerPostcode,
			String customerAddress, String customerAddressDetail) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerPostcode = customerPostcode;
		this.customerAddress = customerAddress;
		this.customerAddressDetail = customerAddressDetail;
	}

	public String getCustomerPw() {
		return customerPw;
	}

	public void setCustomerPw(String customerPw) {
		this.customerPw = customerPw;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerBirthday() {
		return customerBirthday;
	}

	public void setCustomerBirthday(String customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPostcode() {
		return customerPostcode;
	}

	public void setCustomerPostcode(String customerPostcode) {
		this.customerPostcode = customerPostcode;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerAddressDetail() {
		return customerAddressDetail;
	}

	public void setCustomerAddressDetail(String customerAddressDetail) {
		this.customerAddressDetail = customerAddressDetail;
	}

}
