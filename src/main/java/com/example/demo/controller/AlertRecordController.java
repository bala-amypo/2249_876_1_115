package com.example.demo.controller;

import com.example.demo.entity.AlertRecord;
import com.example.demo.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertRecordController {

    private final AlertService alertService;

    public AlertRecordController(AlertService alertService) {
        this.alertService = alertService;
    }

    @PostMapping
    public ResponseEntity<AlertRecord> triggerAlert(@RequestBody AlertRecord alert) {
        return ResponseEntity.ok(alertService.triggerAlert(alert));
    }

    @GetMapping("/shipment/{shipmentId}")
    public ResponseEntity<List<AlertRecord>> getAlertsByShipment(@PathVariable Long shipmentId) {
        return ResponseEntity.ok(alertService.getAlertsByShipment(shipmentId));
    }
}
