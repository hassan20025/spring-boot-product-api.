# Spring Boot Product API

Simple REST API to manage products with image upload using Spring Boot, JPA, PostgreSQL, and MultipartFile.  
Works perfectly with React.js frontend.

## Features
- Add product + image  
- Update product + image  
- Get single product  
- Get all products  
- Get product image  
- Delete product  
- Easy to connect with React.js  

## Tech Stack
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- PostgreSQL  
- Lombok  
- React.js (Frontend)

## How to Run (Backend)

### 1. Create PostgreSQL database:


### 2. Update `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/product
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update

mvn spring-boot:run

API Endpoints
| Method | Endpoint                | Description                   |
| ------ | ----------------------- | ----------------------------- |
| GET    | /api/products           | Get all products              |
| POST   | /api/product/{id}       | Get product by id             |
| POST   | /api/product            | Add product (product + image) |
| GET    | /api/product/{id}/image | Get image                     |
| PUT    | /api/product/{id}       | Update product                |
| DELETE | /api/product/{id}       | Delete product                |


## React.js Example Usage
Add product with image

const formData = new FormData();
formData.append("product", JSON.stringify(product));
formData.append("imageFile", file);

await axios.post("http://localhost:8080/api/product", formData, {
  headers: { "Content-Type": "multipart/form-data" }
});


Get products
const res = await axios.get("http://localhost:8080/api/products");

Get product image
<img src={`http://localhost:8080/api/product/${id}/image`} />

