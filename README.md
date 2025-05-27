
# RPG Data Mapper

A clean and extensible RPG character management backend built with Spring Boot using Domain-Driven Design (DDD), Spring Data JPA, and MapStruct-style mapping logic.

## 🧱 Architecture

This project follows DDD (Domain-Driven Design) principles with a layered architecture:

- **Domain**: Business models and interfaces (`Hero`, `HeroRepository`)
- **Application**: Business logic and services (`HeroService`)
- **Infrastructure**: Data persistence and mappings (`HeroEntity`, `HeroRepositoryAdapter`, `HeroJpaRepository`, `HeroMapper`)
- **Web**: REST controllers and DTOs (`HeroController`, `HeroRequest`, `HeroResponse`)

## 🚀 Getting Started

### Requirements

- Java 21+
- Maven 3.8+
- MySQL 8+

### Run

1. Configure your database connection in `src/main/resources/application.yml`
2. Ensure the database `rpg-data-mapper` is accessible (Flyway will manage schema)
3. Run the application:

## 📦 API Endpoints

- `GET /heroes` - List all heroes
- `POST /heroes` - Create a new hero
- `GET /heroes/{id}` - Retrieve hero by ID
- `PUT /heroes/{id}` - Update hero
- `DELETE /heroes/{id}` - Delete hero

## 🧪 Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- MySQL
- Flyway (Database Migrations)
- JUnit & Mockito (Testing)
- DDD Principles

## 📂 Folder Structure

```
src/
├── main/
│   ├── java/com/rpg/datamapper/
│   │   ├── domain/
│   │   ├── application/
│   │   ├── infrastructure/
│   │   └── web/
│   └── resources/
└── test/
```
