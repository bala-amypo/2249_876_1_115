package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentRecordService shipmentService;

    public ShipmentController(ShipmentRecordService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord s) {
        return shipmentService.createShipment(s);
    }

    @PutMapping("/{id}/status")
    public ShipmentRecord updateStatus(@PathVariable Long id,
                                       @RequestParam String status) {
        return shipmentService.updateShipmentStatus(id, status);
    }

    @GetMapping("/{code}")
    public ShipmentRecord getByCode(@PathVariable String code) {
        return shipmentService.getShipmentByCode(code).orElse(null);
    }

    @GetMapping
    public List<ShipmentRecord> getAll() {
        return shipmentService.getAllShipments();
    }
}
