package com.inditex.prices.infrastructure.configuration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import com.inditex.prices.application.exception.PriceNotFoundException;
import com.inditex.prices.application.exception.PriceServiceException;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    public void handlePriceNotFound_ShouldReturn404() {
        String message = "Price not found";
        PriceNotFoundException exception = new PriceNotFoundException(message);

        ResponseEntity<String> response = globalExceptionHandler.handlePriceNotFound(exception);

        assertEquals(NOT_FOUND, response.getStatusCode());
        assertEquals(message, response.getBody());
    }

    @Test
    public void handlePriceServiceException_ShouldReturn500() {
        PriceServiceException exception = new PriceServiceException("Service error", null);

        ResponseEntity<String> response = globalExceptionHandler.handlePriceServiceException(exception);

        assertEquals(INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("An error occurred while processing your request.", response.getBody());
    }
}
