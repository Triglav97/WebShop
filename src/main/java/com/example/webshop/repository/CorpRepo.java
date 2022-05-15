package com.example.webshop.repository;

import java.util.List;

import com.example.webshop.entity.CorpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorpRepo extends JpaRepository<CorpEntity, Long> {
    
    List<CorpEntity> findByName(String name);

}
