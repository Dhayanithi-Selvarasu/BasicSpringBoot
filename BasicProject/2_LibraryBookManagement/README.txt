Library Book Management

Project structure follows the uploaded sample project:
Application.java, Controller, Exception, Model, Repository, Service,
application.properties, and pom.xml.

Technologies: Spring Boot, Spring Web, Spring Data JPA, MySQL, Validation.
Java version: 17

Setup:
1. Create database: CREATE DATABASE library_db;
2. Set your MySQL password in src/main/resources/application.properties.
3. Open as a Maven project and run Application.java.

Example POST JSON:
{"bookName":"Java Basics","author":"Ravi","price":300.0,"available":true}

API base: /api/books
POST   /add
GET    /{bookid}
PUT    /{bookid}/availability?available=false
DELETE /{bookid}
