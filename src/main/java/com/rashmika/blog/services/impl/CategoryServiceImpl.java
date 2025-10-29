package com.rashmika.blog.services.impl;

import com.rashmika.blog.domain.entities.Category;
import com.rashmika.blog.repositories.CategoryRepository;
import com.rashmika.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategory() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    public Category createCategory(Category category){

        String categoryName = category.getName();

        if(categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Category already exists with name: " + categoryName);
        }

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()){
            if(category.get().getPosts().isEmpty()){
                throw new IllegalStateException("Category has posts associated with it");
            }

            categoryRepository.deleteById(id);
        }
    }


}
