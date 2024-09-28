package com.inditex.prices.application.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceNotFoundExceptionTest {
    @DisplayName("PriceNotFoundException Tests")
    @Test
    public void testExceptionMessage() {
        String errorMessage = "Price not found";
        PriceNotFoundException exception = assertThrows(PriceNotFoundException.class, () -> {
            throw new PriceNotFoundException(errorMessage);
        });

        assertEquals(errorMessage, exception.getMessage());
    }
}