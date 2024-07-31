package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeDtApplication
{


    
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDtApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
