package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.enums.Region;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetProductsQuery {
    private Region region;
    private String category;
    private String  nameOrDescription;
    private ProductSortBy productSortBy;
}
