package com.example.demo.controller;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    private final TemperatureRuleService temperatureRuleService;

    public TemperatureRuleController(TemperatureRuleService temperatureRuleService) {
        this.temperatureRuleService = temperatureRuleService;
    }

    @PostMapping
    public TemperatureRule createRule(@RequestBody TemperatureRule rule) {
        return temperatureRuleService.createRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActiveRules() {
        return temperatureRuleService.getActiveRules();
    }
}
