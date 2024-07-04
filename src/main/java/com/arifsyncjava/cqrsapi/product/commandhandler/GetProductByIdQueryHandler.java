package com.arifsyncjava.cqrsapi.product.commandhandler;

import com.arifsyncjava.cqrsapi.Query;
import com.arifsyncjava.cqrsapi.exceptions.ProductNotFoundException;
import com.arifsyncjava.cqrsapi.product.Product;
import com.arifsyncjava.cqrsapi.product.ProductDTO;
import com.arifsyncjava.cqrsapi.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetProductByIdQueryHandler implements Query<String, ProductDTO> {

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductDTO> execute(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        return ResponseEntity.ok(new ProductDTO(optionalProduct.get()));

    }
}
