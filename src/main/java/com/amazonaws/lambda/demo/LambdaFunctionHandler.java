package com.amazonaws.lambda.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class LambdaFunctionHandler implements RequestHandler<Shipments, BookShipmentResponse> {

    @Override
    public BookShipmentResponse handleRequest(Shipments shipments, Context context) {
        final AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder.standard()
        			.withRegion(Regions.EU_WEST_1)
        			.build();
        
        final DynamoDB dynamoDB = new DynamoDB(ddb);
        
        final Table shipmentsTable = dynamoDB.getTable("shipments");
        
        for (Shipment shipment : shipments.getShipments()) {
        	final Map<String, String> consignor = new HashMap<>();
        	consignor.put("name", shipment.getConsignor().getName());
        	consignor.put("address", shipment.getConsignor().getAddress());
        	consignor.put("city", shipment.getConsignor().getCity());
        	consignor.put("postalCode", shipment.getConsignor().getPostalCode());
        	consignor.put("email", shipment.getConsignor().getEmail());
        	consignor.put("phone", shipment.getConsignor().getPhone());
        	
        	final Map<String, String> consignee = new HashMap<>();
        	consignee.put("name", shipment.getConsignee().getName());
        	consignee.put("address", shipment.getConsignee().getAddress());
        	consignee.put("city", shipment.getConsignee().getCity());
        	consignee.put("postalCode", shipment.getConsignee().getPostalCode());
        	consignee.put("email", shipment.getConsignee().getEmail());
        	consignee.put("phone", shipment.getConsignee().getPhone());
        	
        	final String inputShipmentType = shipment.getShipmentType().getType();
        	final Integer price;
        	if ("small".equalsIgnoreCase(inputShipmentType)) {
        		price = 89;
        	} else if ("medium".equalsIgnoreCase(inputShipmentType)) {
        		price = 139;
        	} else if ("large".equalsIgnoreCase(inputShipmentType)) {
        		price = 259;
        	} else {
        		context.getLogger().log("Erroneous shipment type: " + inputShipmentType);
        		return new BookShipmentResponse("FAILED", 400, "", "");
        	}
        	
        	final Map<String, String> shipmentType = new HashMap<>();
        	shipmentType.put("price", price.toString());
        	shipmentType.put("type", inputShipmentType);
        	
        	final String orderTimestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        	final String uuid = UUID.randomUUID().toString();
        	final String customerId = orderTimestamp + "-" + uuid;
        	
        	final Item shipmentItem = new Item()
        			.withPrimaryKey("customerId", customerId)
        			.withString("orderTimestamp", orderTimestamp)
        			.withMap("consignor", consignor)
        			.withMap("consignee", consignee)
        			.withMap("shipmentType", shipmentType);
        	
        	try {
        		final PutItemOutcome outcome = shipmentsTable.putItem(shipmentItem);
            	final int status = outcome.getPutItemResult().getSdkHttpMetadata().getHttpStatusCode();
            	
            	if (status != 200) {
            		context.getLogger().log("Status after put: " + status);
            	}
        	} catch (Exception e) {
        		context.getLogger().log("Exception: " + e);
        	}
        	
        }

        return new BookShipmentResponse("OK", 200, "asdfghjklzxcvbnm", "http://www.example.com");
    }

} 