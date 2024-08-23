---

## Search API Project

### Overview
The Search API is a Spring Boot application that allows users to search for suppliers based on various criteria such as location, nature of business, and manufacturing processes. The API also supports adding new suppliers and retrieving supplier information with pagination support.

### Features
- **Supplier Search:** Search for suppliers using criteria like location, nature of business, and manufacturing processes.
- **Supplier Management:** Add new suppliers to the database.
- **Pagination:** Support for paginated results for large datasets.
- **Validation:** Input validation to ensure data integrity.
- **Security:** Basic authentication implemented.

### Getting Started

#### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

#### Installation
```bash
git clone <repository-url>
cd searchapi
mvn clean install
```

#### Running the Application
```bash
mvn spring-boot:run
```
The application will be accessible at `http://localhost:8080`.

### Authentication
The API is secured with basic authentication. Use the following credentials to access the endpoints:
- **Username:** `admin`
- **Password:** `admin`

### API Endpoints

#### 1. Query Suppliers
- **Endpoint:** `/api/supplier/query`
- **Method:** `POST`
- **Description:** Retrieve a paginated list of suppliers based on search criteria.
- **CURL Example:**
  ```bash
  curl -u admin:admin -X POST "http://localhost:8080/api/supplier/query?location=Delhi&natureOfBusiness=Manufacturing&manufacturingProcesses=Process1,Process2&page=0&size=10"
  ```

#### 2. Get All Suppliers
- **Endpoint:** `/api/supplier`
- **Method:** `GET`
- **Description:** Retrieve a paginated list of all suppliers or filter by company name.
- **CURL Example:**
  ```bash
  curl -u admin:admin -X GET "http://localhost:8080/api/supplier?companyName=Tech&page=0&size=10"
  ```

#### 3. Add New Supplier
- **Endpoint:** `/api/supplier`
- **Method:** `POST`
- **Description:** Add a new supplier to the database.
- **CURL Example:**
  ```bash
  curl -u admin:admin -X POST "http://localhost:8080/api/supplier" -H "Content-Type: application/json" -d '{"companyName":"Tech Solutions","website":"http://techsolutions.com","location":"Delhi","natureOfBusiness":"Manufacturing","manufacturingProcesses":["Process1","Process2"]}'
  ```

### Additional Details

#### Project Structure
- **Spring Boot Application:** Built using Spring Boot for easy setup and configuration.
- **Data Validation:** Uses annotations for validation to ensure inputs meet required standards.
- **Security:** Basic authentication is set up with a default username and password.
- **Pagination:** Integrated pagination to manage large datasets effectively.

#### Deployment
The application can be deployed on servers like Apache Tomcat or cloud platforms like AWS.

### Conclusion
This project provides a comprehensive API for managing and querying supplier data, with security, validation, and pagination features built-in.

---
