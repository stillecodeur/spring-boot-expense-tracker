package com.anirudh.spring_expense_tracker.controller;

import com.anirudh.spring_expense_tracker.dto.ExpenseDto;
import com.anirudh.spring_expense_tracker.service.ExpenseService;
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

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto expenseDtoNew = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(expenseDtoNew, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable String id) {
        ExpenseDto expenseDtoNew = expenseService.getExpense(id);
        return ResponseEntity.ok(expenseDtoNew);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> categoryList = expenseService.getAllExpenses();
        return ResponseEntity.ok(categoryList);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable String id, @RequestBody ExpenseDto expenseDto) {
        ExpenseDto expenseNewDto = expenseService.updateExpense(id, expenseDto);


        return ResponseEntity.ok(expenseNewDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable String id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
