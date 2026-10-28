# Library Book Management API (No Database)

A Spring Boot REST API using an in-memory `ArrayList`. No database or database configuration is required. Data resets when the application restarts.

## Requirements
- Java 17+
- Maven 3.6+

## Run
```bash
mvn spring-boot:run
```

Base URL: `http://localhost:8080/api/books`

## Endpoints
- `POST /api/books` — add a book
- `GET /api/books` — list all books
- `GET /api/books/{id}` — search by ID
- `PUT /api/books/{id}` — update title, author and availability
- `PATCH /api/books/{id}/availability` — update availability only
- `DELETE /api/books/{id}` — delete a book

## Example requests

Add a book:
```json
{
  "title": "Java Basics",
  "author": "James Gosling",
  "available": true
}
```

Update availability:
```json
{
  "available": false
}
```

Example with curl:
```bash
curl -X POST http://localhost:8080/api/books -H "Content-Type: application/json" -d "{"title":"Java Basics","author":"James Gosling","available":true}"
```

Invalid title/author values return HTTP 400 with validation details. A missing book ID returns HTTP 404.
