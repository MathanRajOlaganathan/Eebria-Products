package com.eebria.service.common;

/**
 *Enum for OrderBy specific values
 * @author Mathan Raj O
 * @version 1.0
 * @since 20-08-2020
 */
public enum OrderBy {
    NAME("name"), PRICE("price");
    private  String orderByCode;

    private OrderBy(String orderByCode) {
        this.orderByCode = orderByCode;
    }

    public String getOrderByCode() {
        return orderByCode;
    }
}
