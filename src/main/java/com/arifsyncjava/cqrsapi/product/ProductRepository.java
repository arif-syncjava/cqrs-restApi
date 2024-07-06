package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.enums.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    @Query ("SELECT p FROM Product WHERE " +
            "(:nameOrDescription is NULL OR p.name LIKE %:nameOrDescription OR p.description LIKE %:nameOrDescription) AND" +
                    "(p.region = :region) AND" +
                    "(p.category is NULL OR p.category.value = :category)" )
    List<Product> findByNameOrDescriptionAndRegionAndCategory (
            String nameOrDescription,
            Region region,
            String category,
            Sort sort
    ) ;



}
