package com.arifsyncjava.cqrsapi.enums;

public enum ErrorMessage {
    PRODUCT_NOT_FOUND ("Product not found"),
    PRODUCT_NAME_REQUIRED ("Product name required"),
    PRICE_INVALID ("Price invalid"),
    REGION_NOT_AVAILABLE("Region not available"),
    CATEGORY_NOT_AVAILABLE ("Category not available"),
    PRODUCT_HAS_PROFANITY("Product contain bad words"),
    PROFANITY_FILTER_DOWN ("External api service down");

    private final String message;

    ErrorMessage( String message) {
        this.message = message;
    }

    public String getMessage () {
        return message;
    }



}
