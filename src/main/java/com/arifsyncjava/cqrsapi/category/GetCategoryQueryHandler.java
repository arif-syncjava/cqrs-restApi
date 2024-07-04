package com.arifsyncjava.cqrsapi.category;

import com.arifsyncjava.cqrsapi.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetCategoryQueryHandler implements Query<Void, List<String>> {

    private final CategoryRepository categoryRepository;


    @Override
    public ResponseEntity<List<String>> execute(Void input) {
        return ResponseEntity.ok(
                categoryRepository.findAll()
                        .stream()
                        .map(Category::getValue)
                        .collect(Collectors.toList())
        );
    }
}
