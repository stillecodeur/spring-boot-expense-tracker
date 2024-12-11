package com.anirudh.spring_expense_tracker.utils;

import com.anirudh.spring_expense_tracker.dto.CategoryDto;
import com.anirudh.spring_expense_tracker.entity.Category;

public class CategoryMapper {


    public static CategoryDto mapToDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }


    public static Category mapToEntity(CategoryDto categoryDto) {
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );
    }


}
