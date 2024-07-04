package com.arifsyncjava.cqrsapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SimpleResponse {
    private String message;
}
