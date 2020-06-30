package com.huan.service;

import com.huan.model.Category;
import com.huan.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Iterable<Category> finAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(Category category) {
        categoryRepository.delete(category.getId());
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findOne(id);
    }
}
