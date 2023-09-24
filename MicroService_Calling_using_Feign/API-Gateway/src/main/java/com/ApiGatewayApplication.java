package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		System.out.println("Api-Gateway Application running on Port No 8765...");
	}
	
	/*
	 *   Dependencies: Devtools, Actuator, Eureka Client, Gateway
	 *   Features:
	 *   		1. Match routes on any request attribures
	 *          2. Integrates with Spring Cloud Discovery Client(Load Balancing)
	 *          3. Path rewriting
	 */

}
