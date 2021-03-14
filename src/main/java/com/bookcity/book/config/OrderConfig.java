package com.bookcity.book.config;

import com.bookcity.book.dao.OrderRepository;
import com.bookcity.book.entity.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Domingos Manuel
 * Date: 06 March 2021
 * OrderConfig object
 */
@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner commandLineRunnerOrder(OrderRepository repository) {
        return args -> {

            List<Order> orderList = new ArrayList<>();
            orderList.add(new Order("Pravin Ghordan", "6 Forsyth Ave, Morningside, Durban, 4001, South Africa", "pravin@soe.co.za", new Long(4), new Integer(1), LocalDate.of(2021, Month.JANUARY,15), 118.29));
            orderList.add(new Order("Maria Ramos", "Level 200, Carlton Centre, 150 Commissioner St, Cbd, Johannesburg, 2001, South Africa", "drramos@transnet.co.za", new Long(2), new Integer(3), LocalDate.of(2020, Month.DECEMBER,22), 112.69));
            orderList.add(new Order("Daniel Mminele", "15 Troye Street, Johannesburg CBD, Downtown, 2001, South Africa", "drmminele@absa.co.za", new Long(6), new Integer(2), LocalDate.of(2021, Month.FEBRUARY,4), 538.00));
            repository.saveAll(orderList);
        };
    }
}
