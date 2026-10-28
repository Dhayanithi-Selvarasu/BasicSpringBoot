Student Course Registration

Project structure follows the uploaded sample project:
Application.java, Controller, Exception, Model, Repository, Service,
application.properties, and pom.xml.

Technologies: Spring Boot, Spring Web, Spring Data JPA, MySQL, Validation.
Java version: 17

Setup:
1. Create database: CREATE DATABASE student_db;
2. Set your MySQL password in src/main/resources/application.properties.
3. Open as a Maven project and run Application.java.

Example POST JSON:
{"studentName":"Arun","courseName":"Java","email":"arun@example.com","age":21}

API base: /api/students
POST   /register
GET    /
GET    /{studentId}
DELETE /{studentId}
