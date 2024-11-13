package com.darvybm.project.apidevelopment.service;

import com.darvybm.project.apidevelopment.model.Category;
import com.darvybm.project.apidevelopment.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product save(Product product);

    Product getById(UUID id);

    List<Product> getAll();

    Product update(UUID id, Product product);

    void delete(UUID id);
}