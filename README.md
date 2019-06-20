# Spring Boot REST API using Spring Boot, JPA and Mockito

Note: for REST CLIENT, I have created two files using HTML and angularJS:  creditcard.html and user.html. So, you can call:
http://localhost:8080/creditcard.html or http://localhost:8080/user.html, if you don't wanna use postman for generating JSON data.

This application, first creates a user account when we pass user JSON object by calling http://localhost:8080/adduser.

For payment processing, this application calls http://localhost:8080/addcreditcard

I have created an orchestration REST API that will orchestrate the calls between the user creation, and the payment processing APIs. 
using http://localhost:8080/orchestra-call

I have performed the unit testing on create, list and delete operations. 


