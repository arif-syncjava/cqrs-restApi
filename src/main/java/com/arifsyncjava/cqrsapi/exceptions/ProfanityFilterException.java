package com.arifsyncjava.cqrsapi.exceptions;

import org.springframework.http.HttpStatus;

public class ProfanityFilterException extends CustomBaseException{
    public ProfanityFilterException(
                                    SimpleResponse simpleResponse) {
        super(HttpStatus.NOT_FOUND, simpleResponse);
    }
}
