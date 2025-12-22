package com.example.demo.service.impl;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository temperatureRuleRepository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository temperatureRuleRepository) {
        this.temperatureRuleRepository = temperatureRuleRepository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {

        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("minTemp must be less than maxTemp");
        }

        if (rule.getEffectiveTo() != null &&
            rule.getEffectiveFrom() != null &&
            rule.getEffectiveTo().isBefore(rule.getEffectiveFrom())) {
            throw new IllegalArgumentException("effectiveTo must be after effectiveFrom");
        }

        return temperatureRuleRepository.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return temperatureRuleRepository.findByActiveTrue();
    }
}
