package com.inditex.prices.infrastructure.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(
				new Info().title("Price Management API").version("1.0").description("API para la gestión de precios"));
	}

	@Bean
	GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("prices").packagesToScan("com.inditex.prices.infrastructure.controller")
				.build();
	}
}
