# JAVA SPRING BOOT REST API WITH POSTGRESQL

Library REST API based on Java Spring, Spring Boot, Hibernate ORM with POSTGRESQL,Swagger API docs

## REST API Endpoints

All inputs and outputs use JSON format.

**To open Swagger (interactive) API documentation, navigate your browser to server:port/swagger-ui.html**

# application.properties for POSTGRESQL and SWAGGER

**spring.datasource.url = jdbc:postgresql://localhost:5432/library_database** => **add your own database**

**spring.datasource.username = [your_username]**

**spring.datasource.password = [your_password]**

**spring.jpa.properties.hibernate,dialect = org.hibernate.dialect.PostgreSQLDialect**

**spring.jpa.hibernate.ddl-auto = update**

**spring.datasource.driver-class-name=org.postgresql.Driver**

**springdoc.swagger-ui.path=/swagger-ui.html**


```
MAPPING 

/books
 GET / - GET ALL BOOKS IN THE LIBRARY
 
/book/{id}
GET / - GET BOOK WITH USING BOOK ID

/book
POST / - ADD BOOK - required : String bookName, String bookAuthor

/book/{id}
PUT / - BOOK UPDATE WITH ID

/book
DELETE / - REMOVE BOOK WITH ID 

/books/filteredByType1
GET / - GET FILTERED TYPE WITH getBooksByBookTypeEndsWith METHOD

/books/filteredByType2
GET / - GET FILTERED TYPE WITH getBooksByBookTypeStartsWith METHOD

/books/filteredByType3
GET / - GET FILTERED TYPE WITH getBooksByBookTypeContains METHOD

/books/{bookAuthor}
GET / - GET BOOKS BY AUTHOR WITH getBooksByBookAuthor METHOD

```
