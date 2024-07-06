package com.arifsyncjava.cqrsapi.product.queryhandler;

import com.arifsyncjava.cqrsapi.Query;
import com.arifsyncjava.cqrsapi.product.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsQueryHandler implements Query<String, List<ProductDTO>> {

    @Override
    public ResponseEntity<List<ProductDTO>> execute(String input) {
        return null;
    }
}
