package com.github.SakuraMatrix.p2.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionApplication {
	static Logger logger = LoggerFactory.getLogger(TransactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
