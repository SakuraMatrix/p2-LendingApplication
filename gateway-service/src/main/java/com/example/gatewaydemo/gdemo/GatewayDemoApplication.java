package com.example.gatewaydemo.gdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayDemoApplication.class, args);
	}

	// Routes
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder){
		return builder.routes()
				.route( p -> p
						.path("/borrowers")
						.uri("lb://borrowers/borrowers"))
				.route( p -> p
						.path("/lenders/**")
						.uri("lb://lenders/lenders"))
				.route( p -> p
						.path("/transactions/**")
						.uri("lb://transactions/transactions"))
				.route( p -> p
						.path("/borrowers/borrowers-requests")
						.uri("lb://borrowers/borrowers/borrowers-requests"))
				.build();
	}

}
