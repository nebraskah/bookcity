CREATE TABLE genres_tbl (
	genre_id SERIAL PRIMARY KEY,
	genre_name VARCHAR(32) UNIQUE NOT NULL
);

INSERT INTO genres_tbl (genre_name) VALUES
('Fiction'),('Novel'),('Narrative'),('Science'),('Mystery'),('Non-fiction'),('Historical Fiction'),('Thriller'),('Horror Fiction'),
('Romance'),('Biography'),('Memoir'),('Poetry'),('Review'),('Suspense'),('Childrens'),('Young Adults'),('Personal Finance'),('Spiritual'),
('Business');

SELECT * FROM genres_tbl;

ALTER TABLE genres_tbl
ALTER COLUMN genre_name TYPE VARCHAR(32) NOT NULL;

CREATE TABLE publishers_tbl (
	publisher_id SERIAL PRIMARY KEY,
	publisher_name VARCHAR(128) UNIQUE NOT NULL,
	publisher_email VARCHAR(64) UNIQUE NOT NULL,
	publisher_country CHAR(3),
	publisher_telephone VARCHAR(20),
	publisher_website VARCHAR(64)
);

INSERT INTO publishers_tbl (publisher_name,publisher_email,publisher_country,publisher_telephone,publisher_website) VALUES
('Addison-Wesley','info@addison-wesley.com','USA','','www.addisonwesley.com'),
('Apress Publishers','info@apress.com','GBR','','www.apress.com'),
('Packt Publishing','info@packt.com','IND','','www.packt.com'),
('O Reilly Media','info@oreilly.com','BRA','','www.oreilly.com'),
('Addison-Wesley Professional','info@addissonwesleypro.com','USA','','www.addissonwesleypro.com'),
('Mango','info@mango.com','USA','','www.mango.com'),
('Manning Publications','info@manning.com','IND','','www.manning.com'),
('Prentice Hall','info@prentice.com','USA','','www.prentice.com');

SELECT * FROM publishers_tbl;

CREATE TABLE authors_tbl (
	author_id SERIAL PRIMARY KEY,
	author_first_name VARCHAR(64) UNIQUE NOT NULL,
	author_last_name VARCHAR(64) UNIQUE NOT NULL,
	author_email VARCHAR(64) UNIQUE NOT NULL,
	author_country CHAR(3),
	author_telephone VARCHAR(20),
	author_website VARCHAR(64)
);

INSERT INTO authors_tbl (author_first_name,author_last_name,author_email,author_country,author_telephone,author_website) VALUES
('Andrew','Hunt','ahunt@gmail.com','USA','0117675000',''),
('Holger','Gast','hgast@gmail.com','USA','',''),
('Iuliana','Cosmina','icosmina@gmail.com','GBR','',''),
('Magnus','Larson','magnus@gmail.com','GBR','',''),
('Martin','Kleppmann','martin@gmail.com','SWE','',''),
('Joshua','Bloch','joshua@gmail.com','USA','',''),
('Erich','Gamma','gof@gmail.com','USA','',''),
('Eric','Evans','esquared@gmail.com','USA','',''),
('Stephen','Covey','scovey@gmail.com','POR','',''),
('Aditya','Bhargava','aditya@gmail.com','IND','0114547000',''),
('Robert','C. Martin','robertcmartin@gmail.com','USA','','www.robertcmartin.com');

SELECT * FROM authors_tbl;

CREATE TABLE books_tbl (
	book_id SERIAL PRIMARY KEY,
	book_author INT REFERENCES authors_tbl(author_id),
	book_genre INT REFERENCES genres_tbl(genre_id),
	book_publisher INT REFERENCES publishers_tbl(publisher_id),
	book_title VARCHAR(64) UNIQUE NOT NULL,
	book_description TEXT,
	book_isbn VARCHAR(32) UNIQUE NOT NULL,
	book_publishing_date DATE NOT NULL,
	book_edition VARCHAR(3) NOT NULL,
	book_page_count INT,
	book_country CHAR(3),
	book_language VARCHAR(16),
	book_website VARCHAR(64),
	book_selling_price NUMERIC(6,2)
);

INSERT INTO books_tbl (book_author,book_genre,book_publisher,book_title,book_description,book_isbn,book_publishing_date,book_edition,book_page_count,book_country,book_language,book_website,book_selling_price) VALUES
(1,4,1,'The Pragmatic Programmer','From Journeyman to Master','9780201616224','1999-10-30','1st',352,'USA','English','www.thepragmaticprogrammer.com',125.99),
(2,5,1,'How to Use Objects','Code and Concepts','9780321995546','2015-12-15','1st',832,'USA','English','',112.69),
(3,7,2,'Pro Spring 5','An In-Depth Guide to the Spring Framework and Its Tools','9781484228074','2017-10-17','5th',878,'GBR','English','www.prospringfive.com',421.13),
(4,9,3,'Hands-On Microservices with Spring Boot and Spring Cloud','Build and deploy Java microservices using Spring Cloud, Istio, and Kubernetes','9781789613477','2019-09-20','1st',668,'IND','English','',118.29),
(5,1,4,'Designing Data-Intensive Applications','The Big Ideas Behind Reliable, Scalable, and Maintainable Systems','9781449373321','2017-04-18','1st',616,'BRA','English','',92.33),
(6,3,1,'Effective Java','Best Practices for the Java Platform','9780134685997','2017-12-27','3rd',416,'USA','English','',538.00),
(1,4,1,'The Pragmatic Programmer Platinum','20th Anniversary Celebration','9780135957052','2019-09-13','2nd',352,'USA','English','',251.41),
(7,8,5,'Design Patterns','Elements of Reusable Object-Oriented Software','9780201633612','1994-11-10','1st',416,'USA','English','www.designpatternsbook.com',918.27),
(8,11,5,'Domain Driven Design','Tackling Complexity in the Heart of Software','9780321125215','2003-08-20','1st',560,'USA','English','',275.43),
(9,20,6,'The 7 Habits of Highly Effective People','Powerful Lessons in Personal Change','9780321125414','2016-01-16','8th',537,'POR','Portuguese','',148.57),
(10,12,7,'Grokking Algorithms','An Illustrated Guide for Programmers and Other Curious People','9781617292230','2016-05-01','1st',256,'IND','English','',198.12),
(11,15,8,'Clean Code','A Handbook of Agile Software Craftsmanship','9780132350884','2008-08-01','1st',464,'USA','English','www.thecleancodebook.com',520.00);

SELECT * FROM books_tbl;
SELECT COUNT(*) FROM books_tbl;

CREATE TABLE stock_tbl (
	stock_id SERIAL PRIMARY KEY,
	stock_book INT REFERENCES books_tbl(book_id) UNIQUE,
	stock_on_hand INT NOT NULL
);

INSERT INTO stock_tbl (stock_book,stock_on_hand) VALUES
(1,18),(2,14),(3,22),(4,11),(5,31),(6,9),(7,20),(8,13),(9,14),(10,15),(11,25),(12,12);

SELECT * FROM stock_tbl;

CREATE TABLE customers_tbl (
	customer_id SERIAL PRIMARY KEY,
	customer_title CHAR(5),
	customer_first_name VARCHAR(64),
	customer_last_name VARCHAR(64) NOT NULL,
	customer_email VARCHAR(64) UNIQUE NOT NULL,
	customer_address VARCHAR(256),
	customer_telephone VARCHAR(20)
);

INSERT INTO customers_tbl (customer_title,customer_first_name,customer_last_name,customer_email,customer_address,customer_telephone) VALUES
('Mr','Pravin','Gordhan','pravin@soe.co.za','6 Forsyth Ave, Morningside, Durban, 4001, South Africa',''),
('Hon','Pep','Guardiola','pep@mancity.co.uk','83 Ducie St, Manchester M1 2JQ, United Kingdom',''),
('Rev','Desmond','Tutu','desmond@gmail.com','Orlando West, Soweto, 1804, South Africa',''),
('Mrs','Maria','Ramos','drramos@transnet.co.za','Level 200, Carlton Centre, 150 Commissioner St, Cbd, Johannesburg, 2001, South Africa',''),
('Dr','Daniel','Mminele','drmminele@absa.co.za','15 Troye Street, Johannesburg CBD, Downtown, 2001, South Africa',''),
('Mr','Sequel','Postgres','pgres@gmail.com','41 Biddulph Street, Boksburg, 1459, South Africa','');

SELECT * FROM customers_tbl;

CREATE TABLE orders_tbl (
	order_id SERIAL PRIMARY KEY,
	order_book INT REFERENCES books_tbl(book_id),
	order_customer INT REFERENCES customers_tbl(customer_id),
	order_date DATE NOT NULL,
	order_qty INT NOT NULL,
	order_delivery_charge NUMERIC(5,2),
	order_total_price NUMERIC(7,2)
);

SELECT * FROM orders_tbl;