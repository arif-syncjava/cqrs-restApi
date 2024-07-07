package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.enums.Region;
import org.springframework.util.StringUtils;

import java.util.List;

public class ProductValidator {

    public static Product execute(CreateProductRequest request,
                                  List<Category> availableCategories) {

        if (nameIsEmpty(request.getName())) {

        }
        if (priceIsNegative(request.getPrice())) {

        }
        if (categoryNotAvailable(request.getCategory(), availableCategories)) {

        }

        if (regionIsNotAvailable(request.getRegion())) {

        }


        return new Product(request);



    }

    private static boolean nameIsEmpty(String name) {
        return StringUtils.isEmpty(name);
    }

    private static boolean priceIsNegative(Double price) {
        return price  !=null  && price <0.00 ;
    }


    private static boolean categoryNotAvailable(String category,
                                         List<Category> availableCategories) {
        return !availableCategories.contains(new Category(category));
    }

    private static boolean regionIsNotAvailable(String candidateRegion) {
        for(Region region: Region.values()) {
            if (region.name().equals(candidateRegion)) {
                return false;
            }
        }
        return true;
    }













}
