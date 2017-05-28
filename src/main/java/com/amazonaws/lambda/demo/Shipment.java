package com.amazonaws.lambda.demo;

public class Shipment {
	
	Consignor consignor;
	Consignee consignee;
	ShipmentType shipmentType;
	
	public Shipment() {
		
	}
	
	public Shipment(Consignor consignor, Consignee consignee, ShipmentType shipmentType) {
		super();
		this.consignor = consignor;
		this.consignee = consignee;
		this.shipmentType = shipmentType;
	}

	public Consignor getConsignor() {
		return consignor;
	}
	
	public void setConsignor(Consignor consignor) {
		this.consignor = consignor;
	}
	
	public Consignee getConsignee() {
		return consignee;
	}
	
	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}
	
	public ShipmentType getShipmentType() {
		return shipmentType;
	}
	
	public void setShipmentType(ShipmentType shipmentType) {
		this.shipmentType = shipmentType;
	}
	
}
