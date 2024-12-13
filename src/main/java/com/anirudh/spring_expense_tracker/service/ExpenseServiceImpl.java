package com.anirudh.spring_expense_tracker.service;

import com.anirudh.spring_expense_tracker.dto.ExpenseDto;
import com.anirudh.spring_expense_tracker.entity.Category;
import com.anirudh.spring_expense_tracker.entity.Expense;
import com.anirudh.spring_expense_tracker.exception.ResourceNotFoundException;
import com.anirudh.spring_expense_tracker.repository.CategoryRepository;
import com.anirudh.spring_expense_tracker.repository.ExpenseRepository;
import com.anirudh.spring_expense_tracker.utils.ExpenseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = expenseRepository.save(ExpenseMapper.mapToEntity(expenseDto));
        if (expenseDto.categoryDto() != null) {
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:"
                    + expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }
        return ExpenseMapper.mapToDto(expense);
    }

    @Override
    public ExpenseDto getExpense(String id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id:" + id));
        return ExpenseMapper.mapToDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map((expense -> ExpenseMapper.mapToDto(expense))).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(String id, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id:" + id));
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        if (expenseDto.categoryDto() != null) {
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(() -> new ResourceNotFoundException("Category not found with id:"
                    + expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }

        return ExpenseMapper.mapToDto(expenseRepository.save(expense));
    }

    @Override
    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
