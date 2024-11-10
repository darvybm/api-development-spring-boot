package com.darvybm.project.apidevelopment.repository;

import com.darvybm.project.apidevelopment.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CategoryRepository extends MongoRepository<Category, UUID> {
}