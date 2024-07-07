package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.product.commandhandler.CreateProductCommandHandler;
import com.arifsyncjava.cqrsapi.product.queryhandler.GetProductByIdQueryHandler;
import com.arifsyncjava.cqrsapi.product.validation.CreateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductCommandHandler createProductCommandHandler;
    private final GetProductByIdQueryHandler getProductByIdQueryHandler;
   // private final GetProductsQueryHandler getProductsQueryHandler;

    @PostMapping (path = "/product")
    public ResponseEntity<ProductDTO> createProduct (
            CreateProductRequest request) {
        return createProductCommandHandler.execute(request);
    }


    @GetMapping (path = "/products/{id}")
    public ResponseEntity<ProductDTO> getProductById (@PathVariable String id) {
        return getProductByIdQueryHandler.execute(id);
    }

//    @GetMapping(path = "/products")
//    @Cacheable ("products")
//    public ResponseEntity<List<ProductDTO>> getProducts (
//            @RequestHeader (required = false, defaultValue = "US" ) String region,
//            @RequestParam (required = false) String category,
//            @RequestParam (required = false) String nameOrDescription,
//            @RequestParam (required = false) String sortBy
//    ) {
//        return getProductsQueryHandler.execute(new GetProductsQuery(
//                Region.valueOf(region),
//                category,
//                nameOrDescription,
//                ProductSortBy.valueOf(sortBy)
//        ));
//
//    }







}
