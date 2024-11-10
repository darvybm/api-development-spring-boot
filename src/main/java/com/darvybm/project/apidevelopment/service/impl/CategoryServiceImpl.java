package com.darvybm.project.apidevelopment.service.impl;

import com.darvybm.project.apidevelopment.model.Category;
import com.darvybm.project.apidevelopment.repository.CategoryRepository;
import com.darvybm.project.apidevelopment.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return List.of();
    }

    @Override
    public Optional<Category> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public Category update(UUID id, Category category) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}