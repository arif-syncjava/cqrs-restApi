package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.ApplicationTests;
import com.arifsyncjava.cqrsapi.exceptions.ProductNotFoundException;
import com.arifsyncjava.cqrsapi.product.commandhandler.DeleteProductCommandHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ApplicationTests.class)
public class DeleteProductCommandHandlerTests {

    @Mock
    private ProductRepository productRepository;
    private DeleteProductCommandHandler deleteProductCommandHandler;

    @BeforeEach
    void setup () {
        deleteProductCommandHandler =
                new DeleteProductCommandHandler(productRepository);
    }

    @Test
    void deleteProductCommandHandler_returnsSuccess () {
        String id = "1";
        Product product = new Product();
        product.setId(id);

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        ResponseEntity responseEntity = deleteProductCommandHandler.execute(id);
        verify(productRepository).delete(product);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);

    }

    @Test
    void  deleteProductCommandHandler_returnsProductNotFoundException () {
        String id = "1";
        Product product = new Product();
        product.setId(id);

        when(productRepository.findById(id)).thenReturn(Optional.empty());
        ProductNotFoundException exception =
                assertThrows(ProductNotFoundException.class,
                        ()->deleteProductCommandHandler.execute(id)) ;
        assertEquals("Product not found",exception.getSimpleResponse().getMessage());





    }






}
