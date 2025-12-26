package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.repository.TemperatureSensorLogRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor-logs")
public class TemperatureSensorLogController {

    private final TemperatureSensorLogRepository logRepository;

    public TemperatureSensorLogController(
            TemperatureSensorLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @PostMapping
    public TemperatureSensorLog createLog(
            @RequestBody TemperatureSensorLog log) {
        return logRepository.save(log);
    }

    @GetMapping
    public List<TemperatureSensorLog> getAllLogs() {
        return logRepository.findAll();
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLog> getLogsByShipmentId(
            @PathVariable Long shipmentId) {
        return logRepository.findByShipmentId(shipmentId);
    }
}
