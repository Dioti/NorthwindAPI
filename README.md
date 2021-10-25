# NorthwindAPI

An API for the Northwind database that returns the content in a JSON format. Built using Spring and running on Apache Tomcat.

---

### Setup

Before running the application, ensure the following: 
- You must have a copy of the Northwinds database running on a mySQL server (v8.0.22+). If you don't have a copy, you will need to download it [here](src/main/resources/Northwind.MySQL5.sql).
- Clone the repository: `https://github.com/Dioti/NorthwindAPI.git`
- Edit the `application.properties` file located in `src/main/resources` with your appropriate database login details
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
  - `keyword=red,yellow,...,blue` (optional) - fetches all categories which contain the specified keywords
- paths:
  - `/northwind/categories/{id}` - fetches category by id

#### Customers:
- endpoint: `/northwind/customers`
- query parameters:
  - `name=Ann` - fetches all customers whose name contains the specified name
  - `title=Mr.` (optional) - fetches all customers with the specified title
  - `region=BC` (optional) - fetches all customers located in the specified region
  - `country=Spain` (optional) - fetches all customers located in the specified country
- paths:
  - `/all` - fetches all customers
  - `/{id}` - fetches customer by id

#### Employees
- endpoint: `/northwind/employees` - fetches all employees
- query parameters:
  - `firstName=Andrew` (optional) - fetches all employees whose first name matches the specified name
  - `lastName=Fuller` (optional) - fetches all employees whose last name matches the specified name
  - `firstName=Andrew&lastName=Fuller` (optional) - fetches all employees whose full name matches the specified names
  - `country=Spain` (optional) - fetches all employees who live in the specified country
  - `firstName=Andrew&country=USA` (optional) - fetches all employees whose first name matches the specified name and who lives in the specified country
  - `lastName=Fuller&country=USA` (optional) - fetches all employees whose last name matches the specified name and who lives in the specified country
- paths:
  - `/id` - fetches employee by id

#### Orders
- endpoint: `/northwind/orders`
- query parameters: 
  - `customerId=1` (optional) - fetches all orders made by the specified customer
  - `employeeId=1` (optional) - fetches all orders handled by the specified employee
- paths:
  - `/id` - fetches order by id
  - `/customer/{customerId}` - fetches all orders made by the specified customer
  - `/location` - fetches all orders made from the specified location
  - `/date` - fetches all orders made using the specified date

#### Products
- endpoint: `/northwind/products` - fetches all products
- query parameters:
- paths:
  - `/available` - fetches all products that are both in-stock and not discontinued
  - `/unavailable` - fetches all products that are both out-of-stock and discontinued

#### Shippers
- endpoint: `/northwind/shippers` - fetches all shippers
- query parameters:
- paths:
  - `/shipperId` - fetches shipper with the specified id

#### Suppliers
- endpoint: `/northwind/suppliers` - fetches all suppliers
- query parameters:
  - `country=USA` - fetches all suppliers located in the specified country
  - `country=UK&city=London` (optional) - fetches all suppliers located in the specified country and city
  - `country=UK&postCode=EC1%204SD` (optional) - fetches all suppliers located in the specified country with the with the specified postal code
  - `name=Exotic%20Liquids` (optional) - fetches supplier with the specified name
- paths:
  - `/supplierId` - fetches supplier with the specified id

---

### To-Do:

- [x] Unit testing using Mockito
- [ ] Build documentation using Swagger UI
- [ ] Rewrite controller methods and add more DTOs
