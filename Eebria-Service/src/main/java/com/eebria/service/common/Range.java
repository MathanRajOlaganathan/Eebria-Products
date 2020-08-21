package com.eebria.service.common;

import lombok.*;
/**
 *Enum for Range  specific values
 * @author Mathan Raj O
 * @version 1.0
 * @since 20-08-2020
 */

@NoArgsConstructor
@AllArgsConstructor
public enum Range {
    CHEAPER("cheaper"),EXPENSIVE("expensive");
    @Getter@Setter
    private  String range;

}
