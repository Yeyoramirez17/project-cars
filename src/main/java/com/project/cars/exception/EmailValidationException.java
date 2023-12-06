package com.project.cars.exception;

public class EmailValidationException extends RuntimeException{

    private static final String message = "The email does not have the correct format";

    public EmailValidationException() {
        super( message );
    }

    public EmailValidationException( String message ) {
        super( message );
    }
}
