package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Limits;
import com.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;

	// http://localhost:8587/microservice-y
	@GetMapping("/microservice-y")
	public Limits retrieveLimits() {
		return new Limits(configuration.getMinimum(), 
						  configuration.getMaximum());
		//	return new Limits(1,1000);
	}
}
