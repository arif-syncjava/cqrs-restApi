package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.enums.Region;
import com.arifsyncjava.cqrsapi.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue (generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.UUIDGenerator")
    private String id;
    private String name;
    private String description;
    private String manufacturer;
    private Double price;
    @Enumerated (EnumType.STRING)
    private Region region;

    @ManyToOne
    @JoinColumn (name = "category_value", referencedColumnName = "value")
    private Category category;


    // auditing
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
