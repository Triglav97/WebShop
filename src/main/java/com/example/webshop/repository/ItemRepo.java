package com.example.webshop.repository;

import com.example.webshop.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<ItemEntity, Long> {
}
