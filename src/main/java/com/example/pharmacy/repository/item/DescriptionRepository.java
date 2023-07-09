package com.example.pharmacy.repository.item;

import com.example.pharmacy.model.item.Description;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DescriptionRepository extends JpaRepository<Description, String> {
}
