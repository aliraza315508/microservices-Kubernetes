package com.in28minutes.microservices.currency_conversion_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionMicroservicesApplication.class, args);
	}

}
