package com.inditex.prices.application.exception;

public class PriceServiceException extends RuntimeException {
	private static final long serialVersionUID = 7539523199435238944L;

	public PriceServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}