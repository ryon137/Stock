package com.example.Stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class Stock {

	public static void main(String[] args) {
		SpringApplication.run(Stock.class, args);
	}

}
