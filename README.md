# BookAShipmentLambda

GET endpoint for the BookAShipment1 project.

## Example request body

{
    "consignor": {
        "name": "",
        "address": "",
        "postalCode": "",
        "city": "",
        "email": "",
        "phone": ""
    },
    "consignee": {
        "name": "",
        "address": "",
        "postalCode": "",
        "city": "",
        "email": "",
        "phone": ""
    },
    "shipmentType": {
        "type": "small",
        "price": 123
    }
}
