package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class LambdaFunctionHandler implements RequestHandler<Shipment, BookShipmentResponse> {

    @Override
    public BookShipmentResponse handleRequest(Shipment input, Context context) {
        context.getLogger().log("Input: " + input);

        return new BookShipmentResponse("OK", 200, "asdfghjklzxcvbnm", "http://www.example.com");
    }

}
