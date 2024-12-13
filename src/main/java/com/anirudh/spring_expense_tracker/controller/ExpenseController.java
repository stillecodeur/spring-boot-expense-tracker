package com.anirudh.spring_expense_tracker.controller;

import com.anirudh.spring_expense_tracker.dto.ExpenseDto;
import com.anirudh.spring_expense_tracker.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Operation(
            summary = "Create Expense REST API",
            description = "REST API to create a new Expense & save it in database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto expenseDtoNew = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(expenseDtoNew, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Expense REST API ",
            description = "REST API to get a Expense by an id from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable String id) {
        ExpenseDto expenseDtoNew = expenseService.getExpense(id);
        return ResponseEntity.ok(expenseDtoNew);
    }

    @Operation(
            summary = "Get all expenses REST API",
            description = " REST API to get all expenses from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> categoryList = expenseService.getAllExpenses();
        return ResponseEntity.ok(categoryList);
    }

    @Operation(
            summary = "Update Expense REST API",
            description = "REST API to update Expense information in database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable String id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto expenseNewDto = expenseService.updateExpense(id, expenseDto);


        return ResponseEntity.ok(expenseNewDto);
    }

    @Operation(
            summary = "Delete Expense REST API",
            description = "REST API to delete a Expense from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
