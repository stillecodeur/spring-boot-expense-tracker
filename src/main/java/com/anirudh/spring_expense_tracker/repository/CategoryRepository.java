package com.anirudh.spring_expense_tracker.repository;

import com.anirudh.spring_expense_tracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
