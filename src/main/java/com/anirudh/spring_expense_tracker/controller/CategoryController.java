package com.anirudh.spring_expense_tracker.controller;

import com.anirudh.spring_expense_tracker.dto.CategoryDto;
import com.anirudh.spring_expense_tracker.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Create Category REST API",
            description = "REST API to create a new Category & save it in database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping("/api/categories")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto categoryNewDto = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryNewDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Category REST API ",
            description = "REST API to get a Category by an id from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable String id) {
        CategoryDto categoryNewDto = categoryService.getCategory(id);
        return ResponseEntity.ok(categoryNewDto);
    }


    @Operation(
            summary = "Get all categories REST API",
            description = " REST API to get all categories from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/api/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryListo = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryListo);
    }

    @Operation(
            summary = "Update Category REST API",
            description = "REST API to update Category information in database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("/api/categories/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable String id, @RequestBody Map<String, String> request) {
        CategoryDto categoryNewDto = categoryService.updateCategory(id, request.get("name"));
        return ResponseEntity.ok(categoryNewDto);
    }

    @Operation(
            summary = "Delete Category REST API",
            description = "REST API to delete a category from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }


}
