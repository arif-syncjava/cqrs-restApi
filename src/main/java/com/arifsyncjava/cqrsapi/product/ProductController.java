package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.product.queryhandler.GetProductByIdQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final GetProductByIdQueryHandler getProductByIdQueryHandler;

    @GetMapping (path = "/products/{id}")
    public ResponseEntity<ProductDTO> getProductById (@PathVariable String id) {
        return getProductByIdQueryHandler.execute(id);
    }







}
