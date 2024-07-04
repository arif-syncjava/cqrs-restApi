package com.arifsyncjava.cqrsapi.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final GetCategoryQueryHandler getCategoryQueryHandler;

    @GetMapping (path = "/getcategories")
    public ResponseEntity<List<String>> getCategories () {
        return getCategoryQueryHandler.execute(null);
    }


}
