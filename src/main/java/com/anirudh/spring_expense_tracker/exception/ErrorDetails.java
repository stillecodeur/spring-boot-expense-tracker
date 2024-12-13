package com.anirudh.spring_expense_tracker.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(
        description = "Error details DTO to transfer between client and server."
)
public class ErrorDetails {
    @Schema(
            description = "Error occured date and time"
    )
    private LocalDateTime timestamp;
    @Schema(
            description = "Error message"
    )
    private String message;
    @Schema(
            description = "Error details"
    )
    private String details;
    @Schema(
            description = "Error code"
    )
    private String errorCode;

    public ErrorDetails(LocalDateTime timestamp, String message, String details, String errorCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }
}
