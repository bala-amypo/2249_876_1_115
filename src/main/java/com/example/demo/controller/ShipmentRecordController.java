package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService shipmentService;

    public ShipmentRecordController(ShipmentRecordService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<ShipmentRecord> createShipment(@RequestBody ShipmentRecord shipment) {
        return ResponseEntity.ok(shipmentService.createShipment(shipment));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ShipmentRecord> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(shipmentService.updateShipmentStatus(id, status));
    }

    @GetMapping("/{code}")
    public ResponseEntity<ShipmentRecord> getByCode(@PathVariable String code) {
        return shipmentService.getShipmentByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ShipmentRecord>> getAll() {
        return ResponseEntity.ok(shipmentService.getAllShipments());
    }
}
