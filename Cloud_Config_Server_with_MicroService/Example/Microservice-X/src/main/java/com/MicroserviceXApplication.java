package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceXApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceXApplication.class, args);
		System.out.println("Microservice-X Application running on Port No 8586... With Config Server Port No 8888...");
	}
	
	/*
	 * Dependencies: Spring Web, Devtools, Actuator, Config Client
	 */

}
