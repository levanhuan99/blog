package com.huan.service;

import com.huan.model.Category;

import java.sql.Blob;

public interface CategoryService {
    Iterable<Category> finAll();

    void save(Category category);

    void remove(Category category);

    Category findById(Long id);
}
