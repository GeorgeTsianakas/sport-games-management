# Sport Games Management

A Spring Boot REST API for managing sports matches and betting odds. It provides CRUD endpoints for Matches and Match Odds, automatic OpenAPI/Swagger documentation, and PostgreSQL persistence. The project includes a test suite and optional Docker Compose setup for local development.

## Contents
- Overview
- Features
- Architecture and Tech Stack
- Domain Model
- Getting Started
  - Prerequisites
  - Running locally (Maven)
  - Configuration
  - API Documentation (Swagger/OpenAPI)
- Running with Docker Compose
- Project Structure
- Testing
- Branches and Alternative Implementations
- Troubleshooting
- Contributing
- License

## Overview
Sport Games Management exposes RESTful endpoints to create, read, update, and delete sports Matches and their associated Match Odds. It uses DTOs and mappers to keep the API layer clean, and documents the API via springdoc-openapi.

Typical use cases:
- Manage upcoming matches for various sports
- Attach betting odds (home/away/draw) to each match
- Query matches and odds via REST endpoints

## Features
- REST API with Spring Boot
- CRUD for Match and MatchOdds entities
- DTO mapping layer using MapStruct-like mappers
- PostgreSQL persistence via Spring Data JPA
- OpenAPI 3/Swagger UI using springdoc-openapi
- Configuration via application.properties
- Unit and integration test coverage for core services and controllers
- Docker Compose definition for local infra

## Architecture and Tech Stack
- Language/Build: Java 11, Maven
- Frameworks: Spring Boot 2.4.x (Web, Data JPA)
- Persistence: PostgreSQL
- API Docs: springdoc-openapi-ui
- Mapping: mapper classes (MapStruct dependency is present in POM; mapper classes are hand-written in code)
- Containerization: Docker Compose (optional)

Key packages:
- controller: REST controllers (MatchController, MatchOddsController)
- service: Service interfaces and implementations
- repository: Spring Data JPA repositories
- dto: Data Transfer Objects
- mapper: DTO<->Entity mappers
- model: JPA entities and enums

## Domain Model
- Match
  - id, description, matchDate, matchTime, teamA, teamB, sport
  - One-to-many with MatchOdds
- MatchOdds
  - id, specifier (e.g., 1, X, 2), odd (decimal)
  - Many-to-one to Match
- Sport (enum)

See src/main/java/com/example/sportgamesmanagement/model for details.

## Getting Started
### Prerequisites
- Java 11 (matching the pom.xml <java.version>)
- Maven 3.8+
- PostgreSQL 12+ (if running locally without Docker)

### Running locally (Maven)
1. Ensure PostgreSQL is running and accessible:
   - Host: localhost
   - Port: 5432
   - Database: sportsdb
   - Username: postgres
   - Password: root
   You can modify these in src/main/resources/application.properties.

2. Start the application:
   - On Windows (included wrapper):
     - mvnw.cmd spring-boot:run
   - On Unix-like systems:
     - ./mvnw spring-boot:run

3. The API will be available at:
   - http://localhost:8080

### Configuration
Relevant properties (src/main/resources/application.properties):
- spring.datasource.url=jdbc:postgresql://localhost:5432/sportsdb
- spring.datasource.username=postgres
- spring.datasource.password=root
- spring.jpa.hibernate.ddl-auto=update
- springdoc.api-docs.path=/api-docs
- server.port=8080

You can override these via environment variables or command-line args, for example:
- mvnw.cmd spring-boot:run -Dspring-boot.run.arguments="--server.port=9090 --spring.datasource.password=secret"

### API Documentation (Swagger/OpenAPI)
When the app is running, OpenAPI and Swagger UI are available at:
- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/api-docs

Controllers:
- MatchController: endpoints under /matches
- MatchOddsController: endpoints under /match-odds (or as defined in the controller)
Use Swagger UI to explore exact endpoints, parameters, and models.

## Running with Docker Compose
This repository includes a docker-compose.yml to spin up PostgreSQL and the app container.

Important notes:
- The compose file defines a db service (postgres-db) and an app service placeholder referencing an image named sport-games-management:latest.
- You will need to build and tag the application image locally, or adjust the compose file to your preferred image/pipeline.

Steps (example):
1. Package the application:
   - mvnw.cmd clean package
   This produces target/sport-games-management-0.0.1-SNAPSHOT.war

2. Build a Docker image (example Dockerfile not provided in repo):
   - Create a Dockerfile that copies the WAR and runs it with a suitable base image (e.g., eclipse-temurin:11-jre).
   - Build: docker build -t sport-games-management:latest .

3. Start services with Compose:
   - docker compose up -d

4. Access the app:
   - http://localhost:8080

Caveat: The compose file’s app.depends_on references a service named postgres, while the DB service is defined as db/postgres-db. If you use this compose file as-is, replace the missing reference or update depends_on to ["db"].

## Project Structure
- docker-compose.yml
- pom.xml
- src/main/java/com/example/sportgamesmanagement
  - config (OpenAPI/Swagger configuration)
  - controller (REST endpoints)
  - dto (data transfer objects)
  - mapper (entity<->DTO mapping)
  - model (JPA entities and enums)
  - repository (Spring Data JPA interfaces)
  - service (business logic)
- src/main/resources/application.properties
- src/test/java/... (unit/integration tests)

## Testing
Run tests with Maven:
- Windows: mvnw.cmd test
- Unix: ./mvnw test

The test suite covers controllers, services, mappers, and models. Check src/test/java for specific cases.

## Branches and Alternative Implementations
The repository may contain additional branches with different implementations or experiments. To review and compare them locally:
- List branches: git fetch --all --prune && git branch -a
- Switch branch: git checkout <branch-name>
- Show diff vs main: git diff main...<branch-name>
- Compare specific files: git diff <branch-a> <branch-b> -- path/to/File.java

If you want, open a ticket or comment which branches to summarize; we’ll document the differences here.

## Troubleshooting
- Database connection refused:
  - Ensure PostgreSQL is running and credentials match application.properties.
  - If using Docker, confirm ports 5432 and 8080 aren’t occupied.
- Swagger UI not loading:
  - Verify the app is running and check http://localhost:8080/swagger-ui.html
  - Confirm springdoc.api-docs.path is /api-docs.
- Docker Compose app fails to start:
  - Ensure the application image is built and tagged as sport-games-management:latest or update the compose file accordingly.
  - Fix depends_on to reference the actual DB service name (db).

## Contributing
1. Fork the repository and create a feature branch.
2. Write tests for your changes where applicable.
3. Submit a pull request with a clear description and rationale.

## License
This project is currently unlicensed. If you need a specific license, please add a LICENSE file (e.g., MIT) and update this section accordingly.
