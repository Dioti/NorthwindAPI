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
- Unit testing using Mockito

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
  - `title=Mr.` (optional) - fetches all customers with the specified title
  - `region=BC` (optional) - fetchhes all customers located in the specified region
  - `country=Spain` (optional) - fetches all customers located in the specified country
- paths:
  - `/all` - fetches all customers
  - `/{id}` - fetches customer by id

### Employees
- endpoint: `northwind/employees` - fetches all employees
- query parameters:
  - `firstName=Andrew` (optional) - fetches all employees whose first name matches the specified name
  - `lastName=Fuller` (optional) - fetches all employees whose last name matches the specified name
  - `firstName=Andrew&lastName=Fuller` (optional) - fetches all employees whose full name matches the specified names
  - `country=Spain` (optional) - fetches all employees who live in the specified country
  - `firstName=Andrew&country=USA` (optional) - fetches all employees whose first name matches the specified name and who lives in the specified country
  - `lastName=Fuller&country=USA` (optional) - fetches all employees whose last name matches the specified name and who lives in the specified country
- paths:
- `/id` - fetches employee by id

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
