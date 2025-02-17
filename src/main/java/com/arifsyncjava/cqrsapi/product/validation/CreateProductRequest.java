package com.arifsyncjava.cqrsapi.product.validation;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateProductRequest {
    private String name;
    private String description;
    private String manufacturer;
    private Double price;
    private String region;
    private String category;
}
