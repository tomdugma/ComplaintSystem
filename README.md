# A complaint system.
Technology stack used: Java 8, Spring, Kafka, MongoDB

## Instalation
In order to run the project.
download/clone the project to your local machine.
you need to run the docker-compose
file which creates and running Kafka & Mongo, command:
```
  docker-compose -f docker-compose.yaml up -d
```
than run the craft demo in another terminal window, command:
```
  java -jar craft-mock.jar
```
  
## Usage
via Postman, run http://localhost:{yourPort}/complaint/register with a valid request body:
e.g :
```
{
    "userId" : "8145b0d6-feb2-4ff6-8546-c0a5eece6f82",
    "subject" : "The seller never sent my item!",
    "complaint" : "I made a purchase and the item hasn’t shipped. It’s been over a week. Please help!",
    "purchaseId" : "c2437271-ec14-40fe-92cc-22284ab3a25f"
}
```
return an ID: 7d6a8f0e-ccbb-459f-9192-349c86351625

paste it to a GET request in a new tab via Postman
http://localhost:{yourPort}/complaint/7d6a8f0e-ccbb-459f-9192-349c86351625

full complaint response
```
{
    "complaintId": "676d7d2b-c6f3-474c-be24-45a6de6af202",
    "complaint": "I made a purchase and the item hasn’t shipped. It’s been over a week. Please help!",
    "subject": "The seller never sent my item!",
    "userId": "8145b0d6-feb2-4ff6-8546-c0a5eece6f82",
    "purchaseId": "c2437271-ec14-40fe-92cc-22284ab3a25f",
    "userInfo": {
        "id": "8145b0d6-feb2-4ff6-8546-c0a5eece6f82",
        "fullName": "Elizabeth Clark",
        "emailAddress": "example@test.com",
        "physicalAddress": "Test Lane 7 Los Angeles"
    },
    "purchaseInfo": {
        "id": "c2437271-ec14-40fe-92cc-22284ab3a25f",
        "userId": "8145b0d6-feb2-4ff6-8546-c0a5eece6f82",
        "productId": "2e2efc79-66c2-498d-bcee-507e06306df8",
        "productName": "Frame",
        "pricePaidAmount": 13.99,
        "priceCurrency": "USD",
        "discountPercent": 0.0,
        "merchantId": "7ef40d26-31b7-4e50-93ea-7ed14dca6811",
        "purchaseDate": "2021-12-20T22:00:00.000+00:00"
    }
}
```
