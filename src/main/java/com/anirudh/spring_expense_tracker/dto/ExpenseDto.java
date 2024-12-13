package com.anirudh.spring_expense_tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO to transfer the data between client and server."
)
public record ExpenseDto(
        String id,
        @Schema(
                description = "Expense amount"
        )
        BigDecimal amount,
        @Schema(
                description = "Date on which expense occured"
        )
        LocalDate expenseDate,
        @Schema(
                description = "Associated expense category"
        )
        CategoryDto categoryDto

) {
}
