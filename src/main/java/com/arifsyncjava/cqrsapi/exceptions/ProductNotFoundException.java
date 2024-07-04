package com.arifsyncjava.cqrsapi.exceptions;

import com.arifsyncjava.cqrsapi.enums.ErrorMessage;
import org.springframework.http.HttpStatus;


public class ProductNotFoundException extends CustomBaseException {
    public ProductNotFoundException() {
        super(
                HttpStatus.NOT_FOUND,
               new SimpleResponse( ErrorMessage.PRODUCT_NOT_FOUND.getMessage()));
    }
}

