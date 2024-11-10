package com.darvybm.project.apidevelopment.service.impl;

import com.darvybm.project.apidevelopment.model.Product;
import com.darvybm.project.apidevelopment.repository.ProductRepository;
import com.darvybm.project.apidevelopment.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product getById(UUID id) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return List.of();
    }

    @Override
    public Product update(UUID id, Product product) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
