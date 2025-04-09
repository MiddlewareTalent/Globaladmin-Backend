package com.middleware.global_admin.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.middleware.global_admin.Response.ErrorResponse;
@RestControllerAdvice
    public class GlobalExceptionHandler {
    @ExceptionHandler(OrganisationNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleOrganisationNotFoundException(OrganisationNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),  // 404 status code
                ex.getMessage(),               // The exception message
                System.currentTimeMillis()    // The current timestamp
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        // Create the error response
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),  // 500 status code
                "An unexpected error occurred: " + ex.getMessage(),  // The exception message
                System.currentTimeMillis()    // The current timestamp
        );

        // Return the error response with the appropriate HTTP status
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}













