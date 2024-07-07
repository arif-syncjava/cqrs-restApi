package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.product.validation.CreateProductRequest;
import lombok.Getter;

@Getter
public class UpdateProductRequest {
    private CreateProductRequest updateProductRequest ;
    private String id;
}
