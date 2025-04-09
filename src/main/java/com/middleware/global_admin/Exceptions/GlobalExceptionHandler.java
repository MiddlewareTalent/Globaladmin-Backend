package com.middleware.global_admin.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

    @ControllerAdvice
    public class GlobalExceptionHandler {

        // Handle OrganisationNotFoundException and return 404 NOT FOUND
        @ExceptionHandler(OrganisationNotFoundException.class)
        public ResponseEntity<String> handleOrganisationNotFoundException(OrganisationNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

        // Handle general exceptions and return 500 INTERNAL SERVER ERROR
        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGeneralException(Exception ex) {
            return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



