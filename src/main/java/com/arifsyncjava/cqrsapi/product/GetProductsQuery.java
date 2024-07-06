package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.enums.Region;

public class GetProductsQuery {
    private String  nameOrDescription;
    private String category;
    private Region region;
    private ProductSortBy productSortBy;
}
