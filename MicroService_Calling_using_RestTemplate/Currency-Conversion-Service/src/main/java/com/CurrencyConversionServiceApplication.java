package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
		System.out.println("Currency Conversion Service Application running on Port No 8100..");
	}
	
	/*
	 * Dependencies: Spring Web, Devtools, Actuator, Config Client
	 */

}
