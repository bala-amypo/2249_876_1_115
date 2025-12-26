package com.example.demo.repository;

import com.example.demo.entity.BreachRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreachRecordRepository
        extends JpaRepository<BreachRecord, Long> {
}
