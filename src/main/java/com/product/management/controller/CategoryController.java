package com.product.management.controller;

import com.product.management.dto.CategoryDto;
import com.product.management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @RequestBody CategoryDto categoryDto
    ) {
        CategoryDto categoryDto1 = categoryService.addCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(categoryDto1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDto> fetchCategory(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> fetchAllCategories(){
        List<CategoryDto> categoryDtos = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> modifyCategory(
            @PathVariable Long id,
            @RequestBody CategoryDto categoryDto)
    {
        CategoryDto categoryDto1 = categoryService.updateCategoryById(id, categoryDto);
        return new ResponseEntity<CategoryDto>(categoryDto1, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        categoryService.removeCategoryById(id);
        return new ResponseEntity<String>("Category Deleted", HttpStatus.OK);
    }
}
