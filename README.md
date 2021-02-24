# A simple online book store app using Java 8, Spring Boot, Spring Data JPA, Spring Security and a PostgreSQL database.

BasicAuth:
Created 2 accounts;
Uname: admin; Pword: admin
Uname: postgres; Pword: postgres

Endpoints:
http://{app-server}/api.bookcity.com/books - to get a list of books and to add a new book to the database
http://{app-server}/api.bookcity.com/books{bookId} - to get the details of a specific book, retrieved by bookId
http://{app-server}/api.bookcity.com/orders - to get a list of orders and to place a new order for a single book
http://{app-server}/api.bookcity.com/orders{orderId} - to get the historic of a specific order, retrieved by orderId

Test data is refreshed/created at app startup and deleted at shutdown

@Todo:
Add a UI front-end
