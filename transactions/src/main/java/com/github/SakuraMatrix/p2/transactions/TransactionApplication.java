package com.github.SakuraMatrix.p2.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TransactionApplication {
	static Logger logger = LoggerFactory.getLogger(TransactionApplication.class);

	public static void main(String[] args) {
		logger.info("Starting application...");
		SpringApplication.run(TransactionApplication.class, args);
	}

}
