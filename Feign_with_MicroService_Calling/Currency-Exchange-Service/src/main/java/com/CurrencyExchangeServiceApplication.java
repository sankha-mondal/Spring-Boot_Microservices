package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
		System.out.println("Currency Exchange Service Application running on Port No 8000 & 8001 & 8002...");
	}
	
	/*
	 * 	Dependencies: Spring Web, Devtools, Actuator, Config Client
	 * 	To create other instances: Run Configuration -> Right Click on Project -> Click duplicate -> 
	 * 							   Change the Name -> Click Argument -> Write "-Dserver.port=8002" -> Apply & Run
	 * 
	 */

}
