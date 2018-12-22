package com.javaee.sistema_acoes.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ResourceNotFoundException(String message, 
    								 Throwable cause, 
    								 boolean enableSuppression, 
    								 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}