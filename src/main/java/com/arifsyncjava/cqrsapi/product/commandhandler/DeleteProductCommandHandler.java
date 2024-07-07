package com.arifsyncjava.cqrsapi.product.commandhandler;


import com.arifsyncjava.cqrsapi.Command;
import com.arifsyncjava.cqrsapi.exceptions.ProductNotFoundException;
import com.arifsyncjava.cqrsapi.product.Product;
import com.arifsyncjava.cqrsapi.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DeleteProductCommandHandler implements Command<String,Void> {

    private final ProductRepository productRepository;

    public DeleteProductCommandHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<Void> execute(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException();
        }
        productRepository.delete(optionalProduct.get());
        return  ResponseEntity.ok().build();
    }
}
