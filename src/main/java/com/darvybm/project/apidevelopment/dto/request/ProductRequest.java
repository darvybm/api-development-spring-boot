package com.darvybm.project.apidevelopment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 100, message = "Name should be between 3 and 100 characters")
    private String name;

    @Size(max = 255, message = "Description cannot be longer than 255 characters")
    private String description;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be a positive value")
    private Double price;

    @NotNull(message = "Stock quantity cannot be null")
    @Positive(message = "Stock quantity must be a positive value")
    private Integer stockQuantity;

    @Size(max = 100, message = "Supplier cannot be longer than 100 characters")
    private String supplier;

    @NotBlank(message = "Category ID is required")
    private String categoryId;
}