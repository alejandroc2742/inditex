package com.inditex.prices.application.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceServiceExceptionTest {

    @Test
    @DisplayName("Test exception message and cause")
    public void testExceptionMessageAndCause() {
        String errorMessage = "Service error";
        Throwable cause = new RuntimeException("Root cause");

        PriceServiceException exception = assertThrows(PriceServiceException.class, () -> {
            throw new PriceServiceException(errorMessage, cause);
        });

        assertEquals(errorMessage, exception.getMessage());
        assertSame(cause, exception.getCause());
    }
}