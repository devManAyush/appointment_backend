# Appointment Booking Backend

A RESTful backend application built with **Java and Spring Boot** to manage doctors, patients, appointment slots and appointment bookings.

The project demonstrates backend development concepts such as layered architecture, REST API development, relational database management, request validation, exception handling and API documentation.

## Overview

The Appointment Booking Backend provides APIs for managing doctor and patient information and handling appointment-related operations.

It uses Spring Boot for application development, Spring Data JPA and Hibernate for database interaction, and MySQL for persistent data storage.

## Features

- **Doctor Management:** Create, retrieve, update and manage doctor information.
- **Patient Management:** Manage patient information.
- **Appointment Management:** Handle appointment-related operations.
- **Slot Management:** Create and manage doctor appointment slots.
- **RESTful APIs:** Expose backend functionality through HTTP endpoints.
- **Request Validation:** Validate incoming request data using Jakarta Bean Validation.
- **Centralized Exception Handling:** Handle application errors consistently using custom exceptions and a global exception handler.
- **Password Hashing:** Use BCrypt for password hashing.
- **API Documentation:** Explore and test endpoints through Swagger UI.
- **Layered Architecture:** Separate controllers, services, repositories, entities and DTOs.

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Backend application framework |
| Spring MVC | REST API development |
| Spring Data JPA | Database access |
| Hibernate | ORM |
| MySQL | Relational database |
| Spring Security | Security configuration |
| BCrypt | Password hashing |
| Maven | Dependency and build management |
| Swagger / OpenAPI | API documentation |
| Docker | Containerization knowledge |

## Project Architecture

The application follows a layered architecture to separate responsibilities and improve maintainability.

```text
src/main/java/
│
├── controller/
│   └── Handles incoming HTTP requests
│
├── service/
│   └── Contains business logic
│
├── repository/
│   └── Handles database operations
│
├── entity/
│   └── Defines database entities
│
├── dto/
│   └── Defines request and response objects
│
├── exception/
│   └── Contains custom exceptions
│
└── config/
    └── Application configuration
```

*Note: Adjust this structure to match the actual package names in your repository.*

## Database Design

The application uses MySQL as its relational database.

The main domain entities include:

- **Doctor:** Stores doctor-related information.
- **Patient:** Stores patient-related information.
- **Slot:** Represents appointment slots associated with doctors.
- **Appointment:** Represents appointment booking information.
- **QueueEntry:** Represents queue-related information.

Entity relationships are managed using JPA and Hibernate.

## Prerequisites

Make sure you have the following installed:

- Java Development Kit (JDK)
- Maven
- MySQL Server
- Git

## Getting Started

### 1. Clone the repository

```bash
git clone YOUR_GITHUB_REPOSITORY_URL
```

### 2. Navigate to the project directory

```bash
cd appointment_backend
```

### 3. Configure MySQL

Create a database in MySQL:

```sql
CREATE DATABASE appointment_db;
```

Configure your database connection in `src/main/resources/application.yaml`.

Use environment variables for database credentials rather than committing passwords to Git.

Example configuration (adapt property names to your application):

```yaml
spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

Set the corresponding environment variables before starting the application.

### 4. Build the application

```bash
mvn clean install
```

### 5. Run the application

```bash
mvn spring-boot:run
```

The application will start on the configured server port.

## API Documentation

Swagger UI is integrated to make API exploration and testing easier.

After starting the application, open:

```text
http://localhost:8080/swagger-ui/index.html
```

OpenAPI specification:

```text
http://localhost:8080/v3/api-docs
```

If you configured a different server port or context path, update these URLs accordingly.

## API Testing

You can explore and test the available endpoints using:

- Swagger UI
- Postman
- cURL

Refer to the Swagger documentation for the available routes, request parameters and response formats.

## Error Handling and Validation

The application uses custom exceptions and centralized exception handling to provide structured error responses.

Request DTOs use validation annotations to validate incoming data before business logic is executed.

## Future Improvements

Planned improvements include:

- Implement concurrency-safe appointment booking.
- Validate doctor-slot ownership during booking.
- Improve partial update operations using dedicated PATCH DTOs.
- Expand automated unit and integration test coverage.
- Implement complete authentication and authorization.
- Improve appointment lifecycle and queue management.
- Add Docker-based application and database deployment.
- Improve database migration management.

## Learning Outcomes

Through this project, I have worked on:

- Designing RESTful backend APIs using Spring Boot.
- Implementing layered application architecture.
- Working with relational databases using JPA and Hibernate.
- Managing entity relationships.
- Implementing request validation and exception handling.
- Documenting and testing APIs using Swagger.
- Understanding backend security and password hashing.

## Author

**Ayushman Singh**

B.Tech – Computer Science and Engineering

- GitHub: [Your GitHub Profile]
- LinkedIn: [Your LinkedIn Profile]

---

*This project is developed as a hands-on learning project to strengthen backend development skills using Java and the Spring ecosystem.*
