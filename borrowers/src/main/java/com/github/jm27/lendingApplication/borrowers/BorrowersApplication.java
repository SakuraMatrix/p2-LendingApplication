package com.github.jm27.lendingApplication.borrowers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //for @GetMapping("/")
@EnableEurekaClient
public class BorrowersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowersApplication.class, args);
	}

}
