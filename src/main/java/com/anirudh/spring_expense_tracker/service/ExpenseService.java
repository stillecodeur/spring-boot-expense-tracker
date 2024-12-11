package com.anirudh.spring_expense_tracker.service;

import com.anirudh.spring_expense_tracker.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpense(String id);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(String id, ExpenseDto expenseDto);

    void deleteExpense(String id);

}
