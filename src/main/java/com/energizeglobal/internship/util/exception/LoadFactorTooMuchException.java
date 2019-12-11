package com.energizeglobal.internship.util.exception;

public class LoadFactorTooMuchException extends RuntimeException {
    public LoadFactorTooMuchException() {
        super();
    }

    public LoadFactorTooMuchException(String message) {
        super(message);
    }
}
