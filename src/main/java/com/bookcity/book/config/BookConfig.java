package com.bookcity.book.config;

import com.bookcity.book.dao.BookRepository;
import com.bookcity.book.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Domingos Manuel
 * Date: 24 February 2021
 * BookConfig object
 */
@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunnerBook(BookRepository repository) {
        return args -> {

            List<Book> bookList = new ArrayList<>();
            bookList.add(new Book("The Pragmatic Programmer","From Journeyman to Master","Science","9780201616224", "Addison Wesley Professional", LocalDate.of(1999, Month.OCTOBER, 30),"1st", 352,"USA","English","www.thepragmaticprogrammer.com","Andrew Hunt",125.99, 59));
            bookList.add(new Book("How to Use Objects","Code and Concepts","Fiction","9780321995546", "Apress Publishers", LocalDate.of(2015, Month.DECEMBER, 15),"1st", 832,"USA","English",null,"Holger Gast",112.69, 14));
            bookList.add(new Book("Pro Spring 5","An In-Depth Guide to the Spring Framework and Its Tools","Romance","9781484228074", "Packt Publishing", LocalDate.of(2017, Month.OCTOBER, 17),"5th", 878,"GBR","English","www.prospringfive.com","Iuliana Cosmina",421.13, 7));
            bookList.add(new Book("Hands-On Microservices with Spring Boot and Spring Cloud","Build and deploy Java microservices using Spring Cloud, Istio, and Kubernetes","Horror-Fiction","9781789613477", "Addison Wesley Professional", LocalDate.of(2019, Month.SEPTEMBER, 20),"1st", 668,"IND","Hindu",null,"Magnus Larson",118.29, 97));
            bookList.add(new Book("Designing Data-Intensive Applications","The Big Ideas Behind Reliable, Scalable, and Maintainable Systems","Drama","9781449373321", "O Reilly Media", LocalDate.of(2017, Month.APRIL, 18),"1st", 616,"BRA","Creole",null,"Martin Kleppmann",92.33, 5));
            bookList.add(new Book("Effective Java","Best Practices for the Java Platform","Poetry","9780134685997", "Addison Wesley Professional", LocalDate.of(2017, Month.DECEMBER, 27),"3rd", 416,"USA","English",null,"Joshua Bloch",538.0, 35));
            repository.saveAll(bookList);

        };
    }
}
