# Spring Boot REST API using JPA and Mockito

This application, first creates a user account by calling http://localhost:8080/adduser.

For payment processing, this application calls http://localhost:8080/addcreditcard.

I have created an orchestration REST API that will orchestrate the calls between the user creation, and the payment processing APIs. 
using http://localhost:8080/orchestra-call


