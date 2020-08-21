package com.eebria.service.common;

/**
 *Enum for Direction  specific values
 * @author Mathan Raj O
 * @version 1.0
 * @since 20-08-2020
 */
public enum Direction {
        ASCENDING("ASC"), DESCENDING("DESC");
        private final String directionCode;
        private Direction(String direction) {
            this.directionCode = direction;
        }
        public String getDirectionCode() {
            return this.directionCode;
        }
    }
