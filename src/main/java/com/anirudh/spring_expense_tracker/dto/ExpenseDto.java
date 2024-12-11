package com.anirudh.spring_expense_tracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDto(
        String id,
        BigDecimal amount,
        LocalDate expenseDate,
        CategoryDto categoryDto

) {
}
