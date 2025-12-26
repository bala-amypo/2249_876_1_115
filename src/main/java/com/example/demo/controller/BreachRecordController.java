package com.example.demo.controller;

import com.example.demo.entity.BreachRecord;
import com.example.demo.repository.BreachRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/breaches")
public class BreachRecordController {

    private final BreachRecordRepository breachRepository;

    public BreachRecordController(
            BreachRecordRepository breachRepository) {
        this.breachRepository = breachRepository;
    }

    @PostMapping
    public BreachRecord createBreach(
            @RequestBody BreachRecord breach) {
        return breachRepository.save(breach);
    }

    @GetMapping
    public List<BreachRecord> getAllBreaches() {
        return breachRepository.findAll();
    }
}
