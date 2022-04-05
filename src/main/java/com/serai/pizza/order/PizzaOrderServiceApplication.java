package com.serai.pizza.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

 /**
 * @author Jaina
 */

@SpringBootApplication
@ComponentScan("com.serai.pizza.order")
public class PizzaOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaOrderServiceApplication.class, args);
		System.out.println("Welcome to Pizza Ordering Service");
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

}
