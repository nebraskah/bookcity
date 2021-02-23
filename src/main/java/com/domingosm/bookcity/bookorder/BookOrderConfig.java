package com.domingosm.bookcity.bookorder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookOrderConfig {

    @Bean
    CommandLineRunner commandLineRunnerBookOrder(BookOrderRepository repository) {
        return args -> {

            List<BookOrder> bookOrderList = new ArrayList<>();
            bookOrderList.add(new BookOrder("Pravin Ghordan", "6 Forsyth Ave, Morningside, Durban, 4001, South Africa", "pravin@soe.co.za", new Long(4), LocalDate.of(2021, Month.JANUARY,15), 118.29));
            bookOrderList.add(new BookOrder("Maria Ramos", "Level 200, Carlton Centre, 150 Commissioner St, Cbd, Johannesburg, 2001, South Africa", "drramos@transnet.co.za", new Long(2), LocalDate.of(2020, Month.DECEMBER,22), 112.69));
            bookOrderList.add(new BookOrder("Daniel Mminele", "15 Troye Street, Johannesburg CBD, Downtown, 2001, South Africa", "drmminele@absa.co.za", new Long(6), LocalDate.of(2021, Month.FEBRUARY,4), 538.00));
            repository.saveAll(bookOrderList);
        };
    }
}
