package com.github.jm27.lendingApplication.borrowers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BorrowersApplication {

	public static void main(String[] args) {
		SpringApplication.run(BorrowersApplication.class, args);
	}

}
