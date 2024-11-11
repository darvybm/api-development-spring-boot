package com.darvybm.project.apidevelopment.service.impl;

import com.darvybm.project.apidevelopment.dto.request.CategoryRequest;
import com.darvybm.project.apidevelopment.exception.BadRequestException;
import com.darvybm.project.apidevelopment.exception.ResourceNotFoundException;
import com.darvybm.project.apidevelopment.model.Category;
import com.darvybm.project.apidevelopment.repository.CategoryRepository;
import com.darvybm.project.apidevelopment.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(UUID id) {
        return findById(id);
    }

    @Override
    public Category save(CategoryRequest categoryRequest) {
        Category category = new Category();
        try {
            modelMapper.map(categoryRequest, category);
            return categoryRepository.save(category);
        }catch (Exception e) {
            throw new BadRequestException("Error saving category", e.getMessage());
        }
    }

    @Override
    public Category update(UUID id, CategoryRequest categoryRequest) {
        Category category = findById(id);

        try {
            modelMapper.map(categoryRequest, category);
            category.setId(category.getId());
            return categoryRepository.save(category);

        }catch (Exception e){
            throw new BadRequestException("Error updating category", e.getMessage());
        }
    }

    @Override
    public void deleteById(UUID id) {
        Category category = findById(id);
        try {
            categoryRepository.delete(category);

        }catch (Exception e){
            throw new BadRequestException("Error deleting category", e.getMessage());
        }
    }

    private Category findById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    }
}
