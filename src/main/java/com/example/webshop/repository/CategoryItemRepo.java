package com.example.webshop.repository;

import java.util.List;

import com.example.webshop.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryItemRepo extends JpaRepository<CategoryEntity, Long> {
    
    List<CategoryEntity> findByName(String name);

}
