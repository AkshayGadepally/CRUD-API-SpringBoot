Student CRUD Application

This is a simple Spring Boot + PostgreSQL application that provides RESTful APIs to manage student records.

Technologies Used

Java 21

Spring Boot

Spring Data JPA

PostgreSQL

Maven

 Features

Add Student (POST)

Get All Students (GET)

Get Student by Roll Number (GET)

Update Student Details (PUT)

Delete Student (DELETE)

Exception Handling for invalid student roll numbers

 How to Run

Clone the project.

Set up your PostgreSQL database (create studentdb).

Update your application.properties with your database credentials:

spring.datasource.url=jdbc:postgresql://localhost:5432/studentdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Run the application as a Spring Boot App.

Access APIs via Postman or any REST client.

 API Endpoints

Method

Endpoint

Description

POST

/students

Add a new student

GET

/students

Get all students

GET

/students/{rollno}

Get student by roll number

PUT

/students/{rollno}

Update student details

DELETE

/students/{rollno}

Delete a student

 Example JSON for POST/PUT

{
    "rollno": 1,
    "name": "John Doe",
    "grade": "A"
}

 Exception Handling Example

If you try to access a roll number that doesn't exist, you will receive:

{
    "message": "Student Not Found",
    "status": 404
}

 API Documentation (Swagger / OpenAPI)

This project provides interactive API documentation using Swagger UI.

- **Swagger UI URL**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI Spec URL**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

You can test all the available API endpoints (CRUD operations) directly from the Swagger UI.


 Author

Built with ❤️ by Akshay
