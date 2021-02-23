package com.domingosm.bookcity.bookorder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookOrderConfig {

    @Bean
    CommandLineRunner commandLineRunnerB2(BookOrderRepository repository) {
        return args -> {

            List<BookOrder> bookOrderList = new ArrayList<>();
            bookOrderList.add(new BookOrder("Pravin Ghordan", "6 Forsyth Ave, Morningside, Durban, 4001, South Africa", "pravin@soe.co.za", LocalDate.now(), 118.29, new Long(4), "Hands-On Microservices with Spring Boot and Spring Cloud"));
            bookOrderList.add(new BookOrder("Maria Ramos", "Level 200, Carlton Centre, 150 Commissioner St, Cbd, Johannesburg, 2001, South Africa", "drramos@transnet.co.za", LocalDate.now(), 112.69, new Long(1), "The Pragmatic Programmer"));
            bookOrderList.add(new BookOrder("Daniel Mminele", "15 Troye Street, Johannesburg CBD, Downtown, 2001, South Africa", "drmminele@absa.co.za", LocalDate.now(), 92.33, new Long(5), "Designing Data-Intensive Applications"));
            repository.saveAll(bookOrderList);
        };
    }
}
