package com.example.demo.controller;

import com.example.demo.entity.TemperatureSensorLog;
import com.example.demo.service.TemperatureLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class TemperatureLogController {

    private final TemperatureLogService logService;

    public TemperatureLogController(TemperatureLogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<TemperatureSensorLog> recordLog(@RequestBody TemperatureSensorLog log) {
        return ResponseEntity.ok(logService.recordLog(log));
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<TemperatureSensorLog>> getLogsByShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(logService.getLogsByShipment(shipmentId));
    }
}
