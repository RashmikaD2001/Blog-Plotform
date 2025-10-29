package com.rashmika.blog.services;

import com.rashmika.blog.domain.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> listCategory();

    Category createCategory(Category category);

    void deleteCategory(UUID id);
}
