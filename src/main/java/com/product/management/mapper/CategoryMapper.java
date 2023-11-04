package com.product.management.mapper;

import com.product.management.dto.CategoryDto;
import com.product.management.entity.Category;

public class CategoryMapper {
    public static final Category mapToCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }

    public static final CategoryDto mapToCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription()
        );
        return categoryDto;
    }
}
