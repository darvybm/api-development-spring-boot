package com.darvybm.project.apidevelopment.dto.response;

import com.darvybm.project.apidevelopment.model.Category;
import com.darvybm.project.apidevelopment.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Integer stockQuantity;
    private Boolean isActive;
    private String supplier;
    private Category category;
}
