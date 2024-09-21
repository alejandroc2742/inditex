package com.inditex.prices.infrastructure.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.inditex.prices.exception.PriceNotFoundException;
import com.inditex.prices.exception.PriceServiceException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<String> handlePriceNotFound(PriceNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(PriceServiceException.class)
	public ResponseEntity<String> handlePriceServiceException(PriceServiceException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("An error occurred while processing your request.");
	}
}
