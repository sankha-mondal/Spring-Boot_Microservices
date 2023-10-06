package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceYApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceYApplication.class, args);
		System.out.println("Microservice-Y Application running on Port No 8587... With Config Server Port No 8888...");
	}
	
	/*
	 * Dependencies: Spring Web, Devtools, Actuator, Config Client
	 */

}

