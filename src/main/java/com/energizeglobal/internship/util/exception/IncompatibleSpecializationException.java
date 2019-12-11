package com.energizeglobal.internship.util.exception;

public class IncompatibleSpecializationException extends RuntimeException {
    public IncompatibleSpecializationException(String message) {
        super(message);
    }

    public IncompatibleSpecializationException() {
        super();
    }
}
