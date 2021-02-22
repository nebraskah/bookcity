package com.domingosm.bookcity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BookcityApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcityApplication.class, args);
	}

	@GetMapping
	public String sayHello() {
		return "Hello World";
	}

}
