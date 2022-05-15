package com.example.webshop.repository;

import java.util.List;
import java.util.Optional;

import com.example.webshop.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountEntity, Long> {
    //Optional<AccountEntity> findById(Long id);
    List<AccountEntity> findByName(String name);
}
