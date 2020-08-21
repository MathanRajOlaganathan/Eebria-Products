package com.eebria.service.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 20-08-2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InValidTypeException extends RuntimeException {
    private String  message;
}
