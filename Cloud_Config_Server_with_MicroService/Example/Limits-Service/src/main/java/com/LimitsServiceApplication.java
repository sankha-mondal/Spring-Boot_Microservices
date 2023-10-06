package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
		System.out.println("Limits Service Application running on Port No 8585... With Config Server Port No 8888...");
	}

	/*
	 * Dependencies: Spring Web, Devtools, Actuator, Config Client
	 */
}
