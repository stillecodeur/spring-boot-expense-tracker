package com.anirudh.spring_expense_tracker.service;

import com.anirudh.spring_expense_tracker.dto.CategoryDto;
import com.anirudh.spring_expense_tracker.entity.Category;
import com.anirudh.spring_expense_tracker.exception.ResourceNotFoundException;
import com.anirudh.spring_expense_tracker.repository.CategoryRepository;
import com.anirudh.spring_expense_tracker.utils.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToEntity(categoryDto);
        return CategoryMapper.mapToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto getCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + id));
        return CategoryMapper.mapToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map((category -> CategoryMapper.mapToDto(category))).collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(String id, String name) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + id));
        category.setName(name);
        return CategoryMapper.mapToDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:" + id));
        categoryRepository.delete(category);
    }
}
