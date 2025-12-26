package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository ruleRepo;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public TemperatureRule getApplicableRule(String productType, LocalDate date) {

        return ruleRepo
                .findFirstByProductTypeAndActiveTrueOrderByIdDesc(productType)
                .orElseThrow(() ->
                        new ResourceNotFoundException("No active rule found for product: " + productType)
                );
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public List<TemperatureRule> getAllRules() {
        return ruleRepo.findAll();
    }
}
