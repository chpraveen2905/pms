package com.product.management.service;

import com.product.management.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto addCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategories();

    CategoryDto updateCategoryById(Long id, CategoryDto categoryDto);

    void removeCategoryById(Long id);
}
