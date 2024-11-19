# **Book Crud Service**

---
The Book Crud Service is a microservice designed to manage  CRUD operations for managing book listings, including optional filters, as well as adding, editing, and deleting books.
## Overview

---
The Book Crud Service is designed to facilitate book exchange for book lovers in a larger scale.
It includes two core service:
- BookListing Service: Manages search books with filter options
- ManageBook Service:   Manages add, edit and deletion of books

## Technologies

---
- Java 18.0.1.1
- SpringBoot for microservice architecture
- PostgreSQL as the primary database

## How to Set Up

---
### Tools Required

- Any Java IDE
- Pgadmin
- JDK
- Postman

### Steps to Clone and Import

---
#### 1. Clone the repository
1. Open a terminal or command prompt
2. Clone the project using below command:
   ````
   git clone https://github.com/AswiniB16/Book-Crud-Repository
   ````
3. Navigate to project directory
   ````
   cd Book-Crud-Repository
   ````
#### 2. Import the project to IDE

#####  For IntelliJ IDE
1. Open IntelliJ IDE
2. Click File > Open 
3. Navigate to project directory and import as a Gradle project
4. For the Initial import/clone it will download dependencies and index the project

### Steps to set Run Configurations

---
1. Click Run > Edit Configurations
2. Click on the + button and select application
3. Select the JDK version and Main class of the project 
4. Click OK to save