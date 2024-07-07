package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.enums.Region;
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
