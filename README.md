Load Management System
A Spring Boot application for managing transportation loads with RESTful API endpoints.
Overview
The Load Management System is a comprehensive solution for tracking and managing transportation loads. It provides a set of APIs to create, retrieve, update, and delete load information, making it easier for shipping companies to manage their logistics operations.
Technologies Used

Spring Boot 3.x
Spring Data JPA
PostgreSQL
Hibernate Validator
Maven

Features

Complete CRUD operations for load management
Flexible filtering options (by shipper, truck type, product type, loading/unloading points)
Input validation with meaningful error messages
Exception handling with appropriate HTTP status codes
UUID generation for unique load IDs
Embedded facility details for loading and unloading information


Setup Instructions
e https://github.com/yourusername/load-management-system.git

Configure PostgreSQL database in application.properties

propertiesCopyspring.datasource.url=jdbc:postgresql://localhost:5432/loadmanagement
spring.datasource.username=your_ postgres
spring.datasource.password=your_ ****

Run the application using Maven

bashCopycd load-management-system
mvn spring-boot:run

Access API endpoints at http://localhost:8080/load

API Documentation
1. Create a new load
POST /load
Request Body:
jsonCopy{
  "facility": {
    "loadingPoint": "delhi",
    "unloadingPoint": "jaipur",
    "loadingDate": "2023-03-19 14:00:00",
    "unloadingDate": "2023-03-20 14:00:00"
  },
  "productType": "chemicals",
  "truckType": "canter",
  "noOfTrucks": 1,
  "weight": 100.0,
  "comment": "",
  "shipperId": "shipper:12345678-1234-1234-1234-123456789012",
  "date": "2023-03-19 10:00:00"
}
Response: (Status Code: 201 Created)
![Screenshot (1442)](https://github.com/user-attachments/assets/af179896-603f-4e0a-aacb-9d0489adc9cc)

jsonCopy{
  "loadId": "load:87654321-4321-4321-4321-987654321098",
  "facility": {
    "loadingPoint": "delhi",
    "unloadingPoint": "jaipur",
    "loadingDate": "2023-03-19 14:00:00",
    "unloadingDate": "2023-03-20 14:00:00"
  },
  "productType": "chemicals",
  "truckType": "canter",
  "noOfTrucks": 1,
  "weight": 100.0,
  "comment": "",
  "shipperId": "shipper:12345678-1234-1234-1234-123456789012",
  "date": "2023-03-19 10:00:00"
}
![Screenshot (1443)](https://github.com/user-attachments/assets/87e19368-e4fe-48fb-9d24-f6900e037ec8)

3. Get loads with filters
GET /load?shipperId=shipper:12345&truckType=canter&productType=chemicals&loadingPoint=delhi&unloadingPoint=jaipur
Response: (Status Code: 200 OK)
jsonCopy[
  {
    "loadId": "load:87654321-4321-4321-4321-987654321098",
    "facility": {
      "loadingPoint": "delhi",
      "unloadingPoint": "jaipur",
      "loadingDate": "2023-03-19 14:00:00",
      "unloadingDate": "2023-03-20 14:00:00"
    },
    "productType": "chemicals",
    "truckType": "canter",
    "noOfTrucks": 1,
    "weight": 100.0,
    "comment": "",
    "shipperId": "shipper:12345678-1234-1234-1234-123456789012",
    "date": "2023-03-19 10:00:00"
  }
]

4. Get load by ID
 ![Screenshot (1445)](https://github.com/user-attachments/assets/81636cfd-f8be-4f0c-a0bb-3bb85e96a0b9)
GET /load/{loadId}
Response: (Status Code: 200 OK)
jsonCopy{
  "loadId": "load:87654321-4321-4321-4321-987654321098",
  "facility": {
    "loadingPoint": "delhi",
    "unloadingPoint": "jaipur",
    "loadingDate": "2023-03-19 14:00:00",
    "unloadingDate": "2023-03-20 14:00:00"
  },
  "productType": "chemicals",
  "truckType": "canter",
  "noOfTrucks": 1,
  "weight": 100.0,
  "comment": "",
  "shipperId": "shipper:12345678-1234-1234-1234-123456789012",
  "date": "2023-03-19 10:00:00"
}
![Screenshot (1447)](https://github.com/user-attachments/assets/632a083c-b0d1-4170-a602-86be8b3b8d63)

6. Update load
PUT /load/{loadId}
Request Body: (Same as POST)
Response: (Status Code: 200 OK)
jsonCopy{
  "loadId": "load:87654321-4321-4321-4321-987654321098",
  "facility": {
    "loadingPoint": "delhi",
    "unloadingPoint": "mumbai",
    "loadingDate": "2023-03-19 14:00:00",
    "unloadingDate": "2023-03-21 14:00:00"
  },
  "productType": "electronics",
  "truckType": "canter",
  "noOfTrucks": 2,
  "weight": 150.0,
  "comment": "Handle with care",
  "shipperId": "shipper:12345678-1234-1234-1234-123456789012",
  "date": "2023-03-19 10:00:00"
}


7. Delete load
DELETE /load/{loadId}
Response: (Status Code: 204 No Content)
Data Model
Load

loadId: String (UUID with "load:" prefix)
facility: Embedded Facility object
productType: String
truckType: String
noOfTrucks: Integer
weight: Double
comment: String
shipperId: String
date: LocalDateTime
![Screenshot (1448)](https://github.com/user-attachments/assets/5e4122df-8eee-4204-bf84-6c6ec8fa1c39)


Facility

loadingPoint: String
unloadingPoint: String
loadingDate: LocalDateTime
unloadingDate: LocalDateTime

Validation

All required fields are validated with appropriate error messages
Embedded Facility object is also validated
Minimum values are enforced for numerical fields

Exception Handling

ResourceNotFoundException: When a load is not found
MethodArgumentNotValidException: When validation fails
Generic exceptions are also handled with appropriate HTTP status codes



Fork the repository
Create your feature branch (git checkout -b feature/amazing-feature)
Commit your changes (git commit -m 'Add some amazing feature')
Push to the branch (git push origin feature/amazing-feature)
Open a Pull Request

License
This project is licensed under the MIT License - see the LICENSE file for details.
