package com.anirudh.spring_expense_tracker.controller;

import com.anirudh.spring_expense_tracker.dto.CategoryDto;
import com.anirudh.spring_expense_tracker.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/api/categories")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto categoryNewDto = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryNewDto, HttpStatus.CREATED);
    }

    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable String id) {
        CategoryDto categoryNewDto = categoryService.getCategory(id);
        return ResponseEntity.ok(categoryNewDto);
    }

    @GetMapping("/api/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryListo = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryListo);
    }

    @PutMapping("/api/categories/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable String id, @RequestBody Map<String, String> request) {
        CategoryDto categoryNewDto = categoryService.updateCategory(id, request.get("name"));
        return ResponseEntity.ok(categoryNewDto);
    }

    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }


}
