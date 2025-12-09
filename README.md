# 📝 Blog Platform Backend (Spring Boot)

A RESTful backend API for a blog platform built using Spring Boot, Spring Security with JWT, and PostgreSQL.

## 🚀 Features

- **User authentication** using JWT
- **Role-based access control** with Spring Security
- **CRUD operations** for:
  - Users
  - Categories
  - Tags
  - Blog Posts
- **Draft & published post handling**
- **Proper exception handling**
- **DTO mapping** using MapStruct
- **PostgreSQL database** running inside Docker
- **Clean layered architecture** (Controller, Service, Repository)

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Docker
- MapStruct
- Maven

## 🧱 Database Design

### Entities
- User
- Post
- Category
- Tag

### Relationships
- **User ↔ Post** → One-to-Many
- **Category ↔ Post** → One-to-Many
- **Post ↔ Tag** → Many-to-Many

## 📋 Prerequisites

- Java 21
- Maven
- Docker & Docker Compose

## 🚀 Getting Started

### 1. Clone the repository
```bash
git clone <repository-url>
cd blog-platform-backend
```

### 2. Start Docker containers
```bash
docker-compose up -d
```

### 3. Run the application
```bash
mvn spring-boot:run
```

## 🧠 Services

### PostgreSQL
- **Host:** `localhost`
- **Port:** `5432`
- **Username:** `postgres`
- **Password:** `root`
- **Database:** `postgres`

### Adminer (Database Management)
- **URL:** [http://localhost:8888](http://localhost:8888)
- **System:** PostgreSQL
- **Server:** `db` or `localhost`
- **Username:** `postgres`
- **Password:** `root`

## 📂 Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── blogplatform/
│   │           ├── controller/
│   │           ├── service/
│   │           ├── repository/
│   │           ├── entity/
│   │           ├── dto/
│   │           ├── mapper/
│   │           └── security/
│   └── resources/
│       ├── application.properties
│       └── application.yml
└── test/
```

## 🔐 API Endpoints

### Authentication
- `POST /api/auth/register` - Register a new user
- `POST /api/auth/login` - Login and receive JWT token

### Users
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Delete user

### Posts
- `GET /api/posts` - Get all posts
- `GET /api/posts/{id}` - Get post by ID
- `POST /api/posts` - Create new post
- `PUT /api/posts/{id}` - Update post
- `DELETE /api/posts/{id}` - Delete post
- `GET /api/posts/published` - Get published posts
- `GET /api/posts/drafts` - Get draft posts

### Categories
- `GET /api/categories` - Get all categories
- `GET /api/categories/{id}` - Get category by ID
- `POST /api/categories` - Create new category
- `PUT /api/categories/{id}` - Update category
- `DELETE /api/categories/{id}` - Delete category

### Tags
- `GET /api/tags` - Get all tags
- `GET /api/tags/{id}` - Get tag by ID
- `POST /api/tags` - Create new tag
- `PUT /api/tags/{id}` - Update tag
- `DELETE /api/tags/{id}` - Delete tag

## 🔑 JWT Authentication

To access protected endpoints, include the JWT token in the Authorization header:
```
Authorization: Bearer <your-jwt-token>
```

## 🐳 Docker Configuration

The project includes a `docker-compose.yml` file that sets up:
- PostgreSQL database container
- Adminer container for database management

To stop the containers:
```bash
docker-compose down
```
