package com.amazonaws.lambda.demo;

public class BookShipmentResponse {

	String status;
	Integer statusCode;
	String transactionId;
	String goToUrl;
	
	public BookShipmentResponse() {
		
	}
	
	public BookShipmentResponse(String status, Integer statusCode, String transactionId, String goToUrl) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.transactionId = transactionId;
		this.goToUrl = goToUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getGoToUrl() {
		return goToUrl;
	}

	public void setGoToUrl(String goToUrl) {
		this.goToUrl = goToUrl;
	}
	
}
