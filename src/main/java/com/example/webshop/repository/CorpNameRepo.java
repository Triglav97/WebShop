package com.example.webshop.repository;

import java.util.List;

import com.example.webshop.entity.CorpNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorpNameRepo extends JpaRepository<CorpNameEntity, Long> {
    
    List<CorpNameEntity> findByName(String name);

}
