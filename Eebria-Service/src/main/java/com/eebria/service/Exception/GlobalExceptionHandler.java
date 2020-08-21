package com.eebria.service.Exception;

import com.eebria.service.common.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *The Global Exception Handler to manage  the entire exception for the application.
 * @author Mathan Raj O
 * @version 1.0
 * @since 19-08-2020
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler({SortingException.class,NotInRangeException.class,InValidTypeException.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
        errorResponse.setMessage(ex.getMessage());
        log.error("ErrorMessage : " + ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler({ProductException.class,})
    public ResponseEntity<ErrorResponse> productExceptionHandler(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage(ex.getMessage());
        log.error("ErrorMessage : " + ex.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exception(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.setMessage(ApplicationConstants.ERROR_MESSAGE);
        log.error("ErrorMessage : " + ex.toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }


}
