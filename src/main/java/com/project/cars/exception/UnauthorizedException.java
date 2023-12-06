package com.project.cars.exception;

public class UnauthorizedException extends RuntimeException {

    private static final String MESSAGE = "Unauthorized";

    public UnauthorizedException(String message) {
        super( message );
    }

    public UnauthorizedException() {
        super( MESSAGE );
    }

}
