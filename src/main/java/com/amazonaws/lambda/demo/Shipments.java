package com.amazonaws.lambda.demo;

import java.util.List;

public class Shipments {

	List<Shipment> shipments;
	
	public Shipments() {
		
	}

	public Shipments(List<Shipment> shipments) {
		super();
		this.shipments = shipments;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}
	
}
