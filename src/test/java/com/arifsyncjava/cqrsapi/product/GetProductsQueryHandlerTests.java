//package com.arifsyncjava.cqrsapi.product;
//
//import com.arifsyncjava.cqrsapi.ApplicationTests;
//import com.arifsyncjava.cqrsapi.category.Category;
//import com.arifsyncjava.cqrsapi.product.queryhandler.GetProductsQueryHandler;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.ResponseEntity;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest(classes = ApplicationTests.class)
//public class GetProductsQueryHandlerTests {
//
//    @Mock
//    private ProductRepository productRepository;
//    private GetProductsQueryHandler getProductsQueryHandler;
//    @BeforeEach
//    void setup() {
//        getProductsQueryHandler  = new GetProductsQueryHandler(productRepository);
//    }
//
//    @Test
//    void getProductsQueryHandler_returnsEmptyList () {
//        when(productRepository
//                .findByNameOrDescriptionAndRegionAndCategory(
//                        null,null, null, null))
//                .thenReturn(Collections.emptyList());
//        ResponseEntity<List<ProductDTO>> responseEntity =
//                getProductsQueryHandler
//                        .execute(new GetProductsQuery(null,null,null,null));
//        assertEquals(responseEntity.getBody(), Collections.emptyList());
//
//    }
//
//    @Test
//    void getProductsQueryHandler_returnsList() {
//        when(productRepository
//                .findByNameOrDescriptionAndRegionAndCategory(any(),any(),any(),any()))
//                .thenReturn(getProducts());
//        ResponseEntity<List<ProductDTO>> responseEntity = getProductsQueryHandler.execute(
//                new GetProductsQuery(null,null,null,null)
//        );
//        List<ProductDTO> actualList = responseEntity.getBody();
//
//        assertEquals(2, actualList.size());
//
//    }
//
//    @Test
//    void testDefineSort_returnsUnsorted () {
//        Sort sort = getProductsQueryHandler.defineSort(null);
//        assertEquals(Sort.unsorted(), sort);
//    }
//
//    @Test
//    void testDefineSort_returnsSorted () {
//        Sort sort = getProductsQueryHandler.defineSort(ProductSortBy.name);
//        assertEquals(Sort.by(Sort.Direction.ASC,"name"),sort);
//    }
//
//
//
//
//
//
//
//
//    private List<Product> getProducts() {
//        Product product1 = new Product();
//        product1.setId("1");
//        product1.setCategory(new Category("Book"));
//
//        Product product2 = new Product();
//        product2.setId("2");
//        product2.setCategory(new Category("Device"));
//        return Arrays.asList(product1,product2);
//    }
//
//
//
//
//
//
//
//}
