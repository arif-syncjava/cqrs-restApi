package com.arifsyncjava.cqrsapi.product.queryhandler;

import com.arifsyncjava.cqrsapi.Query;
import com.arifsyncjava.cqrsapi.product.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetProductsQueryHandler implements Query<GetProductsQuery,
        List<ProductDTO>> {

    private final ProductRepository productRepository;


    @Override
    public ResponseEntity<List<ProductDTO>> execute(GetProductsQuery query) {

        Sort productSort = defineSort (query.getProductSortBy());


        List<Product> productList = productRepository
                .findByNameOrDescriptionAndRegionAndCategory(
                        query.getNameOrDescription(),
                        query.getRegion(),
                        query.getCategory(),
                        productSort

                );
        return ResponseEntity.ok(productList.stream().map(ProductDTO::new)
                .toList());
    }

    public Sort defineSort(ProductSortBy productSortBy) {
        if (productSortBy ==null) {
            return Sort.unsorted();
        }
        ProductSortBy sortBy = ProductSortBy.valueOf(productSortBy.getValue());
        return Sort.by(String.valueOf(sortBy));
    }
}
