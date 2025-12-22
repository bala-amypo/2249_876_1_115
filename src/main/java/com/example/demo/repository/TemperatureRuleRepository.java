package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();
}
