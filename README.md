# Pathology Management Mini Module (Backend)

A small but functional pathology mini-module built using **Spring Boot, JPA, and MySQL**, covering:
- Test Master Setup
- Test Order Creation
- Test Result Entry

This project is designed as a backend technical assignment.

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL (Docker)
- Maven

---

## Entities
- Test
- TestOrder
- TestResult

---

## Prerequisites
- Java 17+
- Maven
- Docker & Docker Compose

---

## Database Setup (Using Docker)

### 1. Start MySQL using Docker
Run the following command:

```bash
docker run --name pathology-mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=pathology_db \
  -p 3306:3306 \
  -d mysql:8
