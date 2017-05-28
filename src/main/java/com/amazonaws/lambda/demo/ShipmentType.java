package com.amazonaws.lambda.demo;

public class ShipmentType {

	String type;
	Integer number;
	
	public ShipmentType(String type, Integer number) {
		super();
		this.type = type;
		this.number = number;
	}
	
	public ShipmentType() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
