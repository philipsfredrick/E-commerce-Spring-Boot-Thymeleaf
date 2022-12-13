package com.nonso.ecommerce.service;

import com.nonso.ecommerce.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();

    void addCategory(Category category);

    void removeCategoryById(Integer id);

    Optional<Category> getCategoryById(Integer id);
}
