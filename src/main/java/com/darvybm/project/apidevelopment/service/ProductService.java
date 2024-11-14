package com.darvybm.project.apidevelopment.service;

import com.darvybm.project.apidevelopment.dto.request.ProductRequest;
import com.darvybm.project.apidevelopment.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product save(ProductRequest productRequest);

    Product getById(UUID id);

    List<Product> getAll();

    Product update(UUID id, ProductRequest productRequest);

    void delete(UUID id);
}