package com.bookcity;

import com.bookcity.book.entity.Book;
import com.bookcity.book.entity.Order;
import com.bookcity.book.dao.OrderRepository;
import com.bookcity.book.dao.BookRepository;
import com.bookcity.book.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookcityApplicationTests {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@MockBean
	private OrderRepository orderRepository;

	@Test
	public void getBooksTest() {

		/* Only true at application start-up */
		when(bookRepository.findAll()).thenReturn(Stream.of(
				new Book("The Pragmatic Programmer","From Journeyman to Master","Science","9780201616224", "Addison Wesley Professional", LocalDate.of(1999, Month.OCTOBER, 30),"1st", 352,"USA","English","www.thepragmaticprogrammer.com","Andrew Hunt",125.99, 59),
				new Book("How to Use Objects","Code and Concepts","Fiction","9780321995546", "Apress Publishers", LocalDate.of(2015, Month.DECEMBER, 15),"1st", 832,"USA","English",null,"Holger Gast",112.69, 14),
				new Book("Pro Spring 5","An In-Depth Guide to the Spring Framework and Its Tools","Romance","9781484228074", "Packt Publishing", LocalDate.of(2017, Month.OCTOBER, 17),"5th", 878,"GBR","English","www.prospringfive.com","Iuliana Cosmina",421.13, 7),
				new Book("Hands-On Microservices with Spring Boot and Spring Cloud","Build and deploy Java microservices using Spring Cloud, Istio, and Kubernetes","Horror-Fiction","9781789613477", "Addison Wesley Professional", LocalDate.of(2019, Month.SEPTEMBER, 20),"1st", 668,"IND","Hindu",null,"Magnus Larson",118.29, 97),
				new Book("Designing Data-Intensive Applications","The Big Ideas Behind Reliable, Scalable, and Maintainable Systems","Drama","9781449373321", "O Reilly Media", LocalDate.of(2017, Month.APRIL, 18),"1st", 616,"BRA","Creole",null,"Martin Kleppmann",92.33, 5),
				new Book("Effective Java","Best Practices for the Java Platform","Poetry","9780134685997", "Addison Wesley Professional", LocalDate.of(2017, Month.DECEMBER, 27),"3rd", 416,"USA","English",null,"Joshua Bloch",538.0, 35)).collect(Collectors.toList()));
		assertEquals(6, bookService.getBooks().size());
	}

	@Test
	public void addBookTest() {

		Book b = new Book("The 7 Habits of Highly Effective People","Powerful Lessons in Personal Change","Business","9780321125414", "Franklin Covey Publication", LocalDate.of(2016, Month.JANUARY, 16),"8th", 537,"POR","Portuguese",null,"Stephen Covey",148.57, 12);
		bookService.addBook(b);
		verify(bookRepository, times(1)).save(b);
	}

	@Test
	public void getBookTest() {
		when(bookRepository.findAll()).thenReturn(Stream.of(
				new Book("Effective Java","Best Practices for the Java Platform","Poetry","9780134685997", "Addison Wesley Professional", LocalDate.of(2017, Month.DECEMBER, 27),"3rd", 416,"USA","English",null,"Joshua Bloch",538.0, 35)).collect(Collectors.toList()));
		assertEquals(1, bookService.getBooks().size());
	}

	@Test
	public void getOrdersTest() {

		/* Only true at application start-up */
		when(orderRepository.findAll()).thenReturn(Stream.of(
				new Order("Pravin Ghordan", "6 Forsyth Ave, Morningside, Durban, 4001, South Africa", "pravin@soe.co.za", new Long(4), new Integer(1), LocalDate.of(2021, Month.JANUARY,15), 118.29),
				new Order("Maria Ramos", "Level 200, Carlton Centre, 150 Commissioner St, Cbd, Johannesburg, 2001, South Africa", "drramos@transnet.co.za", new Long(2), new Integer(3), LocalDate.of(2020, Month.DECEMBER,22), 112.69),
				new Order("Daniel Mminele", "15 Troye Street, Johannesburg CBD, Downtown, 2001, South Africa", "drmminele@absa.co.za", new Long(6), new Integer(2), LocalDate.of(2021, Month.FEBRUARY,4), 538.00)).collect(Collectors.toList()));
		assertEquals(3, bookService.getOrders().size());
	}

	@Test
	public void getOrderTest() {
		when(orderRepository.findAll()).thenReturn(Stream.of(
				new Order("Pravin Ghordan", "6 Forsyth Ave, Morningside, Durban, 4001, South Africa", "pravin@soe.co.za", new Long(4), new Integer(1), LocalDate.of(2021, Month.JANUARY,15), 118.29)).collect(Collectors.toList()));
		assertEquals(1, bookService.getOrders().size());
	}

	@Test
	void contextLoads() {
	}

}
