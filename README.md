# Spring Boot GraphQL & REST API with GraphQL Client

This project is a backend application built using **Spring Boot**, providing both **GraphQL** and **REST API** endpoints. It also includes a **GraphQL client** that consumes data from external GraphQL APIs — suitable for hybrid or microservice architectures.

## Features

- GraphQL API: queries and mutations for flexible data access
- REST API: standard endpoints for compatibility
- GraphQL Client: uses `WebClient` to fetch data from external GraphQL services
- DTOs and MapStruct for clean entity-data separation
- Input validation using `javax.validation` annotations
- Global exception handling with custom error response
- Spring Data JPA integration
- Modular architecture: `Controller → Service → Repository`

## Tech Stack

- `Java 21`
- `Spring Boot 3.x`
- `Spring Web (REST API)`
- `Spring for GraphQL`
- `Spring Data JPA`
- `MapStruct`
- `Hibernate Validator`
- `WebClient` (GraphQL Client)
- `MySQL`

## Ports
  - Port:9090 -> Inventory Service
  - Port:9091 -> Catalog Service

## Sample Use Cases

- `getProductById(id)` → Available in GraphQL
- `/product` → Rest Api with validation (create product)
- `/product/{productId}` → Rest Api (update and delete)
- `catalog/products` → Rest Api (get all products)

## Running the Project

```bash
# Clone the repository
git clone https://github.com/Thekishor/SpringBootGraphQL

