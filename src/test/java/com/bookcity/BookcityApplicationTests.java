package com.bookcity;

import com.bookcity.book.dao.BookOrderRepository;
import com.bookcity.book.dao.BookRepository;
import com.bookcity.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookcityApplicationTests {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@MockBean
	private BookOrderRepository bookOrderRepository;

	@Test
	void contextLoads() {
	}

}
