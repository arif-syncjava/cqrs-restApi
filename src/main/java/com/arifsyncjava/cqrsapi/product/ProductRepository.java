package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.enums.Region;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,String> {

    /*

    @Query ("SELECT p FROM Product p WHERE " +
            "(:nameOrDescription is null or p.name" +
            " like %:nameOrDescription% and p.description " +
            "like %:nameOrDescription%) and" +
                    "(p.region = :region) and" +
                    "(p.category is null or p.category.value = :category)" )
    List<Product> findByNameOrDescriptionAndRegionAndCategory (
            String nameOrDescription,
             Region region,
            String category,
            Sort sort
    ) ;

     */



}
