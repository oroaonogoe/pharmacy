package com.example.pharmacy.repository.item;

import com.example.pharmacy.model.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
