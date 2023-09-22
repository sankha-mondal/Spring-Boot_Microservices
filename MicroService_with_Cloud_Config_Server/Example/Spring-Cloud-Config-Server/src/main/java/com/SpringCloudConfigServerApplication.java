package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
		System.out.println("Spring Cloud Config Server Application running on Port No 8888...");
	}
	
	/*
	 * 		Dependencies: spring-cloud-config-server, Dev tools
	 * 
	 * 		Call Limit-Service: http://localhost:8888/limits-service/default
	 * 							http://localhost:8888/limits-service/qa
	 * 							http://localhost:8888/limits-service/dev
	 * 
	 * 		Call Microservice-X: http://localhost:8888/microservice-x-service/default
	 * 							 http://localhost:8888/microservice-x-service/qa
	 *                           http://localhost:8888/microservice-x-service/dev
	 *                           
	 *      Call Microservice-Y: http://localhost:8888/microservice-y-service/default
	 *      					 http://localhost:8888/microservice-y-service/qa
	 *      					 http://localhost:8888/microservice-y-service/dev
	 */

}
