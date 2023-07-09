package com.example.pharmacy.repository.item;

import com.example.pharmacy.model.item.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
