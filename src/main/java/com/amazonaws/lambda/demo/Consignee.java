package com.amazonaws.lambda.demo;

public class Consignee {

	String name;
	String address;
	String postalCode;
	String city;
	String email;
	String phone;
	
	public Consignee() {
		
	}
	
	public Consignee(String name, String address, String postalCode, String city, String email, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
