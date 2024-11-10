package com.darvybm.project.apidevelopment.service;

import com.darvybm.project.apidevelopment.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAll();

    Optional<Category> getById(UUID id);

    Category save(Category category);

    Category update(UUID id, Category category);

    void deleteById(UUID id);
}