package com.arifsyncjava.cqrsapi.category;

import com.arifsyncjava.cqrsapi.ApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ApplicationTests.class)
public class GetCategoryQueryHandlerTests {

    @Mock
    private CategoryRepository categoryRepository;

    private GetCategoryQueryHandler getCategoryQueryHandler;

    @BeforeEach
    void setup () {
        getCategoryQueryHandler = new GetCategoryQueryHandler(categoryRepository);
    }

    @Test
    void getCategoryQueryHandler_returnsList () {
        List<Category> categories = Arrays.asList(
                new Category("Book"),
                new Category("Device"),
                new Category("Cloth")
        );
        when(categoryRepository.findAll()).thenReturn(categories);
        List<String> expected = Arrays.asList("Book","Device","Cloth");
        ResponseEntity<List<String>> actual = getCategoryQueryHandler.execute(null);
        assertEquals(ResponseEntity.ok(expected), actual);

    }

    @Test
    void getCategoryQueryHandler_returnsEmptyList () {
        when(categoryRepository.findAll()).thenReturn(Collections.emptyList());
        List<String> expected = Collections.emptyList();
        ResponseEntity<List<String>> actual = getCategoryQueryHandler.execute(null);
        assertEquals(ResponseEntity.ok(expected),actual);

    }







}
