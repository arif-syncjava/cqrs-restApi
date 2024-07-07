package com.arifsyncjava.cqrsapi.product;

import com.arifsyncjava.cqrsapi.enums.Region;
import com.arifsyncjava.cqrsapi.category.Category;
import com.arifsyncjava.cqrsapi.product.validation.CreateProductRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter @Setter
@Entity
@Table (name = "products")
public class Product {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue (generator = "UUID")
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

    public Product (CreateProductRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.manufacturer = request.getManufacturer();
        this.price = request.getPrice();
        this.category = new Category(request.getCategory());
        this.region =Region.valueOf(request.getRegion());
    }










}
