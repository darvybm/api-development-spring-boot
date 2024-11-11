package com.darvybm.project.apidevelopment.service;

import com.darvybm.project.apidevelopment.dto.request.CategoryRequest;
import com.darvybm.project.apidevelopment.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {

    List<Category> getAll();

    Category getById(UUID id);

    Category save(CategoryRequest categoryRequest);

    Category update(UUID id, CategoryRequest categoryRequest);

    void deleteById(UUID id);
}