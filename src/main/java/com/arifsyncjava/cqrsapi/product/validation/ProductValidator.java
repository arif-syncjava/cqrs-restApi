package com.arifsyncjava.cqrsapi.product.validation;

import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.enums.ErrorMessage;
import com.arifsyncjava.cqrsapi.enums.Region;
import com.arifsyncjava.cqrsapi.exceptions.InvalidProductException;
import com.arifsyncjava.cqrsapi.exceptions.SimpleResponse;
import com.arifsyncjava.cqrsapi.product.Product;
import org.springframework.util.StringUtils;

import java.util.List;

public class ProductValidator {

    public static Product execute(CreateProductRequest request,
                                  List<Category> availableCategories) {

        if (nameIsEmpty(request.getName())) {
            throw new InvalidProductException(
                    new SimpleResponse(
                            ErrorMessage.PRODUCT_NOT_FOUND.getMessage()), request);


        }
        if (priceIsNegative(request.getPrice())) {
            throw new InvalidProductException(
                    new SimpleResponse(
                            ErrorMessage.PRODUCT_NOT_FOUND.getMessage()), request);


        }
        if (categoryNotAvailable(request.getCategory(), availableCategories)) {
            throw new InvalidProductException(
                    new SimpleResponse(
                            ErrorMessage.PRODUCT_NOT_FOUND.getMessage()), request);


        }

        if (regionIsNotAvailable(request.getRegion())) {
            throw new InvalidProductException(
                    new SimpleResponse(
                            ErrorMessage.PRODUCT_NOT_FOUND.getMessage()), request);

        }

        if (ProfanityValidator.hasProfanity()) {
            throw new InvalidProductException(
                    new SimpleResponse(
                            ErrorMessage.PRODUCT_HAS_PROFANITY.getMessage()), request);

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
