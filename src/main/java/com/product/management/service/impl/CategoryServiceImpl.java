package com.product.management.service.impl;

import com.product.management.dao.CategoryRepository;
import com.product.management.dto.CategoryDto;
import com.product.management.entity.Category;
import com.product.management.exception.ResourceNotFoundException;
import com.product.management.mapper.CategoryMapper;
import com.product.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDto addCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategry = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategry);
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category not found with Id: " + id));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(
                        (category -> CategoryMapper.mapToCategoryDto(category)))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategoryById(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category not found with Id: " + id));
        category.setDescription(categoryDto.getDescription());
        category.setName(categoryDto.getName());
        Category updatedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void removeCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category not found with Id: " + id));
        categoryRepository.delete(category);
    }


}
