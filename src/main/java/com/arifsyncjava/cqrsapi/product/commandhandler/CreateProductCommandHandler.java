package com.arifsyncjava.cqrsapi.product.commandhandler;

import com.arifsyncjava.cqrsapi.Command;
import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.product.validation.CreateProductRequest;
import com.arifsyncjava.cqrsapi.product.ProductDTO;
import com.arifsyncjava.cqrsapi.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CreateProductCommandHandler
        implements Command<CreateProductRequest, ProductDTO> {

    private final ProductRepository productRepository;



    @Override
    public ResponseEntity<ProductDTO> execute(
            CreateProductRequest request, List<Category> availableCategories) {
        return null;

    }


}
