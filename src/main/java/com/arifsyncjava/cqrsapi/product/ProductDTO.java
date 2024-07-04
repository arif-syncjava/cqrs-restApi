package com.arifsyncjava.cqrsapi.product;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private String manufacturer;
    private Double price;
    private String category;

    public ProductDTO (Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.manufacturer = product.getManufacturer();
        this.price = product.getPrice();
        this.category = product.getCategory().getValue();
    }





}
