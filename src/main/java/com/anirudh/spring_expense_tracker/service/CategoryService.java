package com.anirudh.spring_expense_tracker.service;

import com.anirudh.spring_expense_tracker.dto.CategoryDto;

import java.util.List;


public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategory(String id);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(String id, String name);

    void deleteCategory(String id);

}
