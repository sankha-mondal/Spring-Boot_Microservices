package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
		System.out.println("Currency Exchange Service Application running on Port No 8000 & 8001...");
	}
	
	/*
	 * Dependencies: Spring Web, Devtools, Actuator, Config Client
	 */

}
