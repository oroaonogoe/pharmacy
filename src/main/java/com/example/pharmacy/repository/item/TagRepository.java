package com.example.pharmacy.repository.item;

import com.example.pharmacy.model.item.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
