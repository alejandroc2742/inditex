package com.inditex.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.inditex.prices")
public class PricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}

}
