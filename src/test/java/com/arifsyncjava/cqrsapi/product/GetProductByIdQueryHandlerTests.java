package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.ApplicationTests;
import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.exceptions.ProductNotFoundException;
import com.arifsyncjava.cqrsapi.product.commandhandler.GetProductByIdQueryHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ApplicationTests.class)
public class GetProductByIdQueryHandlerTests {

    @Mock
    private ProductRepository productRepository;
    private GetProductByIdQueryHandler getProductByIdQueryHandler;

    @BeforeEach
    void setup () {
        getProductByIdQueryHandler = new GetProductByIdQueryHandler(productRepository);
    }

    @Test
    void getProductByIdQueryHandler_returnsSuccess () {
        String id = "1";
        Product product = new Product();
        product.setId(id);
        product.setCategory(new Category("Book"));
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity<ProductDTO>  responseEntity = getProductByIdQueryHandler.execute(id);
        verify(productRepository).findById(id);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(responseEntity.getBody(), new ProductDTO(product));
    }

    @Test
    void getProductByIdQueryHandler_returnsProductNotFoundException () {
        String id = "1";
        Product product = new Product();
        product.setId(id);
        product.setCategory(new Category("Book"));
        when(productRepository.findById(id)).thenReturn(Optional.empty());
        ProductNotFoundException exception =
                assertThrows(ProductNotFoundException.class, ()->{
                    getProductByIdQueryHandler.execute(id);
                });
        assertEquals("Product not found", exception.getSimpleResponse().getMessage());
        assertEquals(exception.getStatus(), HttpStatus.NOT_FOUND);


    }








}
