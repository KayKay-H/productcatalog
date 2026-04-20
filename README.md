# Product Catalog Web Application

## Overview

Product Catalog is a Spring Boot web application that allows users to manage and browse a collection of products through a web interface. The application demonstrates full integration between a web front-end, server-side validation, and a relational database.

---

## Features

The application allows users to:

• User registration and login (Spring Security)
• Role-based access (Admin and User)
• Add and view products
• Database persistence using JPA
• Responsive UI using Bootstrap

---

## Technologies Used

- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL
- Docker

---

## Application Pages

### Home Page
The entry point of the application providing navigation to other pages.

### Products Page
Displays all stored products in a table format with filtering and sorting options.

### Add Product Page
Allows users to submit a form to add a new product. The server validates the input before saving the data.

### About Page
Provides information about the application.

---

## Database

The application uses an **H2 in-memory database**.

Sample data is automatically inserted on startup using:
data.sql
Each product includes:

- ID
- Name
- Brand
- Price
- Category
- Created timestamp

---
## Project Structure

src/main/java/com/example/productcatalog

controller
ProductController.java

model
Product.java

repository
ProductRepository.java

service
ProductService.java

ProductcatalogApplication.java

src/main/resources

templates
home.html
about.html
add-product.html
product-list.html

static/css
style.css

application.properties
data.sql

---
## How to Run the Application

Clone the repository
git clone https://github.com/KayKay-H/productcatalog
Navigate to the project directory
cd productcatalog
Run the application
mvn spring-boot:run
Open the application in your browser
http://localhost:8080

## Running with Docker (QA Environment):

Build the project:
mvn clean package
Run Docker:
docker-compose up --build
Open browser:
http://localhost:8080

## Environment Configuration:

• Dev Profile:
Uses H2 in-memory database
• QA Profile:
Uses MySQL database via Docker

Switching environments is done using:
spring.profiles.active

---
## H2 Database Console

The H2 database console can be accessed at:

http://localhost:8080/h2-console

Use the following connection settings:

JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: leave blank
