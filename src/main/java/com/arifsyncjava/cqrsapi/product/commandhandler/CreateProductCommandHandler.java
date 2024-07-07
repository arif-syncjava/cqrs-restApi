package com.arifsyncjava.cqrsapi.product.commandhandler;

import com.arifsyncjava.cqrsapi.Command;
import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.category.CategoryRepository;
import com.arifsyncjava.cqrsapi.product.Product;
import com.arifsyncjava.cqrsapi.product.validation.CreateProductRequest;
import com.arifsyncjava.cqrsapi.product.ProductDTO;
import com.arifsyncjava.cqrsapi.product.ProductRepository;
import com.arifsyncjava.cqrsapi.product.validation.ProductValidator;
import com.arifsyncjava.cqrsapi.product.validation.ProfanityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateProductCommandHandler
        implements Command<CreateProductRequest,ProductDTO> {


    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public ResponseEntity<ProductDTO> execute(
            CreateProductRequest  request) {
        Product validatedProduct = ProductValidator.execute(request, categoryRepository.findAll());
        Product savedProduct = productRepository.save(validatedProduct);
        return ResponseEntity.ok(new ProductDTO(savedProduct));
    }
}
