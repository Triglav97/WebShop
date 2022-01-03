package com.example.webshop.repository;

import com.example.webshop.entity.PasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepo extends JpaRepository<PasswordEntity, Long> {
}
