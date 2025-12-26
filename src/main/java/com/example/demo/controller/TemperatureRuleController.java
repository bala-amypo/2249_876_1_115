package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temperature-rules")
public class TemperatureRuleController {

    private final TemperatureRuleRepository ruleRepository;

    public TemperatureRuleController(
            TemperatureRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @PostMapping
    public TemperatureRule createRule(
            @RequestBody TemperatureRule rule) {
        return ruleRepository.save(rule);
    }

    @GetMapping
    public List<TemperatureRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return ruleRepository.findByActiveTrue();
    }
}
