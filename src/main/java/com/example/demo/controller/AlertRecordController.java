package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.repository.AlertRecordRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertRecordController {

    private final AlertRecordRepository alertRepository;

    public AlertRecordController(
            AlertRecordRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    @PostMapping
    public AlertRecord createAlert(
            @RequestBody AlertRecord alert) {
        return alertRepository.save(alert);
    }

    @GetMapping
    public List<AlertRecord> getAllAlerts() {
        return alertRepository.findAll();
    }
}
