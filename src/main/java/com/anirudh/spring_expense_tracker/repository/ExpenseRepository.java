package com.anirudh.spring_expense_tracker.repository;

import com.anirudh.spring_expense_tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, String> {
}
