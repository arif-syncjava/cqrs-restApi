package com.arifsyncjava.cqrsapi.product.validation;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProfanityApiResponse {
    private String original;
    private String censored;
    private boolean has_profanity;
}
