package com.darvybm.project.apidevelopment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Boolean isActive;

    private Category category;
    private List<ProductImage> images;
    private List<Review> reviews;
    private Supplier supplier;
}