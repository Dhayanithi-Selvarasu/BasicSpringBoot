Online Food Order System

Project structure follows the uploaded sample project:
Application.java, Controller, Exception, Model, Repository, Service,
application.properties, and pom.xml.

Technologies: Spring Boot, Spring Web, Spring Data JPA, MySQL, Validation.
Java version: 17

Setup:
1. Create database: CREATE DATABASE food_order_db;
2. Set your MySQL password in src/main/resources/application.properties.
3. Open as a Maven project and run Application.java.

Example POST JSON:
{"customerName":"Arun","foodItem":"Pizza","quantity":2,"price":250.0}

API base: /api/orders
POST   /add
GET    /
GET    /{orderId}
PUT    /{orderId}
PATCH  /{orderId}/quantity?quantity=3
DELETE /{orderId}
