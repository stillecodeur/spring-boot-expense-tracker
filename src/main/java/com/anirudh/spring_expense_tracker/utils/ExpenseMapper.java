package com.anirudh.spring_expense_tracker.utils;

import com.anirudh.spring_expense_tracker.dto.CategoryDto;
import com.anirudh.spring_expense_tracker.dto.ExpenseDto;
import com.anirudh.spring_expense_tracker.entity.Category;
import com.anirudh.spring_expense_tracker.entity.Expense;

public class ExpenseMapper {

    public static Expense mapToEntity(ExpenseDto expenseDto) {
        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                new Category(
                        expenseDto.categoryDto().id(),
                        expenseDto.categoryDto().name()
                )
        );
    }

    public static ExpenseDto mapToDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                ));
    }
}
