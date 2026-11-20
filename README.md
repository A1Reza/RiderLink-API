
# 🚗 RiderLink API

<p align="center">
  A secure RESTful API for a ride-sharing platform, built with Java 21 and Spring Boot.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?logo=openjdk" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot" />
  <img src="https://img.shields.io/badge/Spring%20Security-Enabled-6DB33F?logo=springsecurity" />
  <img src="https://img.shields.io/badge/PostgreSQL-Database-4169E1?logo=postgresql" />
  <img src="https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?logo=swagger" />
</p>

---

## 📖 Overview

**RiderLink API** is a Spring Boot RESTful application designed to manage users in a ride-sharing platform.

The application supports two account types: **Riders** and **Drivers**. It provides secure user registration, database-backed authentication, protected user information, and API documentation through Swagger UI.

The project follows a layered architecture to keep business logic, data access, security, and API endpoints organized and maintainable.

## ✨ Features

- 👤 Rider and Driver registration
- 🔐 Secure password encryption using BCrypt
- 🛡️ Spring Security authentication
- 🗄️ PostgreSQL database integration
- 🧬 JPA entity inheritance using `SINGLE_TABLE`
- ✅ Request validation with Jakarta Bean Validation
- 🚫 Duplicate username prevention
- 🔎 Protected user directory
- 🙋 Authenticated user profile endpoint
- ❤️ Public health check endpoint
- 📚 Interactive API documentation with Swagger UI

## 🛠️ Technologies

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot | Application framework |
| Spring Web | REST API development |
| Spring Data JPA | Database persistence |
| Spring Security | Authentication and security |
| Hibernate | ORM |
| PostgreSQL | Relational database |
| Lombok | Boilerplate code reduction |
| Jakarta Validation | Input validation |
| BCrypt | Password hashing |
| Springdoc OpenAPI | API documentation |
| Maven | Dependency management |

## 📁 Project Structure

```text
src/
└── main/
    ├── java/com/riderlink/
    │   ├── config/
    │   │   └── SecurityConfig.java
    │   ├── controller/
    │   │   ├── AuthController.java
    │   │   ├── DriverSignupController.java
    │   │   ├── HealthController.java
    │   │   ├── RiderSignupController.java
    │   │   └── UserDirectoryController.java
    │   ├── dto/
    │   │   ├── request/
    │   │   └── response/
    │   ├── exception/
    │   │   └── UsernameAlreadyExistsException.java
    │   ├── model/
    │   │   ├── UserDao.java
    │   │   ├── Rider.java
    │   │   └── Driver.java
    │   ├── repository/
    │   ├── service/
    │   └── RiderlinkApplication.java
    └── resources/
        └── application.properties
```

## ⚙️ Requirements

Before running the application, make sure you have:

- Java Development Kit (JDK) 21
- Apache Maven
- PostgreSQL
- IntelliJ IDEA (recommended)

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/A1Reza/RiderLink-API.git
```

### 2. Create the database

Create a PostgreSQL database named:

```sql
CREATE DATABASE riderlinkdb;
```

### 3. Configure database connection

Update `src/main/resources/application.properties`:

```properties
server.port=8090

spring.datasource.url=jdbc:postgresql://localhost:5432/riderlinkdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD

spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

Replace `YOUR_PASSWORD` with your PostgreSQL password.

### 4. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run `RiderlinkApplication.java` directly from IntelliJ IDEA.

The application starts at:

```text
http://localhost:8090
```

## 🔗 API Endpoints

### Authentication & Registration

| Method | Endpoint | Description | Access |
|---|---|---|---|
| POST | `/auth/signup/rider` | Register a new rider | Public |
| POST | `/auth/signup/driver` | Register a new driver | Public |
| GET | `/auth/me` | Get authenticated user profile | Protected |

### User Directory

| Method | Endpoint | Description | Access |
|---|---|---|---|
| GET | `/users` | Retrieve all registered users | Protected |

### Health Check

| Method | Endpoint | Description | Access |
|---|---|---|---|
| GET | `/health` | Check application status | Public |

## 🧪 Example Requests

### Rider Registration

**POST** `/auth/signup/rider`

```json
{
  "username": "rider1",
  "password": "Secure123!",
  "fullName": "Sara Ahmadi",
  "phone": "09121234567",
  "homeAddress": "Tehran, Valiasr St."
}
```

### Driver Registration

**POST** `/auth/signup/driver`

```json
{
  "username": "driver1",
  "password": "Secure123!",
  "fullName": "Reza Karimi",
  "phone": "09127654321",
  "vehicleLicenseNumber": "ABC-1234"
}
```

### Successful Health Check

**GET** `/health`

Response:

```text
OK
```

## 📚 Swagger API Documentation

RiderLink uses Springdoc OpenAPI to provide interactive API documentation.

After starting the application, access:

**Swagger UI:**

```text
http://localhost:8090/swagger-ui/index.html
```

**OpenAPI JSON:**

```text
http://localhost:8090/v3/api-docs
```

## 🔒 Security

- Passwords are hashed using BCrypt before being stored.
- Authentication is handled by Spring Security.
- User information is retrieved from the PostgreSQL database.
- Protected endpoints require authentication.
- Passwords are excluded from API response DTOs.
- Duplicate usernames are rejected.

## 🏗️ Architecture

The application follows a layered architecture:

- **Controller:** Handles HTTP requests and responses.
- **Service:** Contains business logic and application operations.
- **Repository:** Manages database access through Spring Data JPA.
- **Model:** Defines entities and their relationships.
- **DTO:** Transfers request and response data.
- **Config:** Contains application security configuration.
- **Exception:** Handles custom application exceptions.

## 👨‍💻 Author

**Reza Asadipour**

GitHub: [@A1Reza](https://github.com/A1Reza)

---

<p align="center">
  Built with ☕ Java and ❤️ Spring Boot
</p>
