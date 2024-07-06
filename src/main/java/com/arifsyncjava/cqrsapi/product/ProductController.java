package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.enums.Region;
import com.arifsyncjava.cqrsapi.product.queryhandler.GetProductByIdQueryHandler;
import com.arifsyncjava.cqrsapi.product.queryhandler.GetProductsQueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final GetProductByIdQueryHandler getProductByIdQueryHandler;
    private final GetProductsQueryHandler getProductsQueryHandler;


    @GetMapping (path = "/products/{id}")
    public ResponseEntity<ProductDTO> getProductById (@PathVariable String id) {
        return getProductByIdQueryHandler.execute(id);
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<ProductDTO>> getProducts (
            @RequestHeader (required = false, defaultValue = "US" ) String region,
            @RequestParam (required = false) String category,
            @RequestParam (required = false) String nameOrDescription,
            @RequestParam (required = false) String sortBy
    ) {
        return getProductsQueryHandler.execute(new GetProductsQuery(
                Region.valueOf(region),
                category,
                nameOrDescription,
                ProductSortBy.valueOf(sortBy)
        ));

    }







}
