package com.anirudh.spring_expense_tracker.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO to transfer the data between client and server."
)
public record CategoryDto(
        String id,
        @Schema(
                description = "Category name"
        )
        String name
) {
}
