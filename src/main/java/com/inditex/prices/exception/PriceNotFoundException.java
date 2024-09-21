package com.inditex.prices.exception;

public class PriceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -7954217163396396772L;

	public PriceNotFoundException(String message) {
        super(message);
    }
}

