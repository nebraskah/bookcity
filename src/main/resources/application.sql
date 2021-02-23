CREATE TABLE books_tbl (
	book_id SERIAL PRIMARY KEY,
	book_title VARCHAR(255) UNIQUE NOT NULL,
	book_description TEXT,
	book_genre VARCHAR(255) NOT NULL,
	book_isbn VARCHAR(255) UNIQUE NOT NULL,
	book_publisher VARCHAR(255) NOT NULL,
	book_publishing_date DATE NOT NULL,
	book_edition VARCHAR(255) NOT NULL,
	book_page_count INT,
	book_country VARCHAR(255),
	book_language VARCHAR(255),
	book_website VARCHAR(255),
	book_author VARCHAR(255) NOT NULL,
	book_selling_price NUMERIC(6,2),
	book_stock_on_hand INT
);

SELECT * FROM books_tbl;

CREATE TABLE book_orders_tbl (
	order_id SERIAL PRIMARY KEY,
	order_customer_name VARCHAR(255) NOT NULL,
	order_customer_address VARCHAR(255) NOT NULL,
	order_customer_email VARCHAR(255) NOT NULL,
	order_date DATE NOT NULL,
	order_amount NUMERIC(7,2),
	order_book_id INT REFERENCES books_tbl(book_id),
	order_book_title VARCHAR(255) REFERENCES books_tbl(book_title)
);

SELECT * FROM book_orders_tbl;