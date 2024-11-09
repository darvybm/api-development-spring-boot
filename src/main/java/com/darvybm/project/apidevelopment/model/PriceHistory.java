package com.darvybm.project.apidevelopment.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Document(collection = "price_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceHistory {

    @Id
    private String id;

    private Double price;
    private LocalDateTime changeDate;

    private String productId;  // Referencia al producto
}