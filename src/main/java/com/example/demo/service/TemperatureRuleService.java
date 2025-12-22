package com.example.demo.service;

import com.example.demo.entity.TemperatureRule;

import java.util.List;

public interface TemperatureRuleService {

    TemperatureRule createRule(TemperatureRule rule);

    List<TemperatureRule> getActiveRules();
}
