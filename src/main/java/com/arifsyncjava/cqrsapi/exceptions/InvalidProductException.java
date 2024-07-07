package com.arifsyncjava.cqrsapi.exceptions;

import com.arifsyncjava.cqrsapi.product.CreateProductRequest;
import org.springframework.http.HttpStatus;

public class InvalidProductException extends CustomBaseException{
    public InvalidProductException(SimpleResponse simpleResponse,
                                   CreateProductRequest request) {
        super(HttpStatus.NOT_FOUND, simpleResponse);
    }
}
