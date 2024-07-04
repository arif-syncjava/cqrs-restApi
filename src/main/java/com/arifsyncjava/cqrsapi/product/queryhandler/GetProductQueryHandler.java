package com.arifsyncjava.cqrsapi.product.queryhandler;

import com.arifsyncjava.cqrsapi.Query;
import org.springframework.http.ResponseEntity;

public class GetProductQueryHandler implements Query {

    @Override
    public ResponseEntity execute(Object input) {
        return null;
    }

}
