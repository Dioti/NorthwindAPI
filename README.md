# NorthwindAPI

An API for the Northwind database that returns the content in a JSON format. Built using Spring and running on Apache Tomcat.

---

### Setup

Before running the application, ensure the following: 
- You must have a copy of the Northwinds database running on a mySQL server (v8.0.22+). If you don't have a copy, you will need to download it [here](src/main/resources/Northwind.MySQL5.sql).
- Clone the repository: `https://github.com/Dioti/NorthwindAPI.git`
- Edit the `application.properties` file with your appropriate database login details
- Ensure that you have set up the `northwinds` database as a database and are successfully connected to it

---

### Features

The program implements several features, including:
- Fetches relevant information from the Northwind database
- RESTful approach
- DTO design pattern
- Multiple endpoints using path variables and query parameters

---

### API Documentation

#### Categories:
- endpoint: `/northwind/categories` - fetches all categories
- query parameters:
  - (optional) `keyword=red,yellow,...,blue` - fetches all categories which contain the specified keywords
- paths:
  - `/northwind/categories/{id}` - fetches category by id

#### Customers:
- endpoint: `northwind/customers`
- query parameters:
- `name=Ann` - fetches all customers whose name contains the specified name
- (optional) `title=Mr.` - fetches all customers with the specified title
- (optional) `region=BC` - fetchhes all customers located in the specified region
- (optional) `country=Spain` - fetches all customers located in the specified country
- paths:
- `/all` - fetches all customers
- `/{id}` - fetches customer by id

### Employees
- endpoint: `northwind/employees` - fetches all employees
- query parameters:
- 
- paths:
- 

### Orders
- endpoint:
- query parameters:
- 
- paths:
- 

### Products
- endpoint:
- query parameters:
- 
- paths:
- 

### Shippers
- endpoint:
- query parameters:
- 
- paths:
- 

### Suppliers
- endpoint:
- query parameters:
- 
- paths:
- 

---

### To-Do:

[ ] Build documentation using Swagger UI
[x] Unit testing using Mockito
