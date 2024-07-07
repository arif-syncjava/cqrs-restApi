package com.arifsyncjava.cqrsapi.product.commandhandler;

import com.arifsyncjava.cqrsapi.Command;
import com.arifsyncjava.cqrsapi.category.CategoryRepository;
import com.arifsyncjava.cqrsapi.exceptions.ProductNotFoundException;
import com.arifsyncjava.cqrsapi.product.Product;
import com.arifsyncjava.cqrsapi.product.ProductDTO;
import com.arifsyncjava.cqrsapi.product.ProductRepository;
import com.arifsyncjava.cqrsapi.product.UpdateProductRequest;
import com.arifsyncjava.cqrsapi.product.validation.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateProductCommandHandler
        implements Command<UpdateProductRequest, ProductDTO> {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;



    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductRequest updateRequest) {
        Optional<Product>
                optionalProduct = productRepository
                .findById(updateRequest.getId());
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        Product validatedProduct =
                ProductValidator.execute(
                        updateRequest.getUpdateProductRequest(),
                        categoryRepository.findAll());
        validatedProduct.setId(optionalProduct.get().getId());
        validatedProduct.setCreatedAt(optionalProduct.get().getCreatedAt());
        Product updatedProduct  = productRepository.save(validatedProduct);

        return ResponseEntity.ok(new ProductDTO(updatedProduct));
    }
}
