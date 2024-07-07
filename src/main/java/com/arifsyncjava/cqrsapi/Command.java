package com.arifsyncjava.cqrsapi;

import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.product.CreateProductRequest;
import com.arifsyncjava.cqrsapi.product.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Command <I,O> {
    ResponseEntity<O> execute (I input);

    ResponseEntity<ProductDTO> execute(
            CreateProductRequest request, List<Category> availableCategories);
}
