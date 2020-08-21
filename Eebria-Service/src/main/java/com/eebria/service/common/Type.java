package com.eebria.service.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *Enum for Type  specific values
 * @author Mathan Raj O
 * @version 1.0
 * @since 20-08-2020
 */
@NoArgsConstructor
@AllArgsConstructor
public enum Type {
    BEER("beer"),CIDER("cider");
    @Getter @Setter
    private String type;
}
