package com.project.cars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler( { EmailValidationException.class,
            PasswordIncorrectException.class,
            CustomerNotExistException.class,
            CustomerExistsException.class,
            PurchaseNotExistException.class
        }
    )
    public ProblemDetail baRequestException( RuntimeException exception ) {
        return ProblemDetail.forStatusAndDetail( HttpStatus.BAD_REQUEST, exception.getMessage() );
    }

    @ExceptionHandler({ UnauthorizedException.class })
    public ProblemDetail unauthorizedException(AuthenticationException authenticationException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, authenticationException.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail accessDeniedException(AccessDeniedException accessDeniedException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, accessDeniedException.getMessage());
    }

}
