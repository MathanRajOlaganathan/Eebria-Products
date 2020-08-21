package com.eebria.service.Exception;

import lombok.Data;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 20-08-2020
 */
@Data
public class ErrorResponse {
    private int  errorCode;
    private String message;

}
