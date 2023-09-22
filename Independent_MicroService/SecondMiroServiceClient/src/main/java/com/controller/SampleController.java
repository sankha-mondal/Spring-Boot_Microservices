package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("second")
public class SampleController {

	// http://localhost:8282/second/sayHello
	@GetMapping(value = "sayHello")
	public String sayHello() {
		return "Welcome to Spring microservice with say Hello with second client";
	}
}
