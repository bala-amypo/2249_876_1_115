package com.example.demo.controller;

import com.example.demo.entity.ShipmentRecord;
import com.example.demo.service.ShipmentRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService shipmentRecordService;

    public ShipmentRecordController(ShipmentRecordService shipmentRecordService) {
        this.shipmentRecordService = shipmentRecordService;
    }

    @PostMapping
    public ShipmentRecord createShipment(@RequestBody ShipmentRecord shipment) {
        return shipmentRecordService.createShipment(shipment);
    }

    @PutMapping("/{id}/status")
    public ShipmentRecord updateStatus(@PathVariable Long id,
                                       @RequestParam String status) {
        return shipmentRecordService.updateShipmentStatus(id, status);
    }

    @GetMapping("/{code}")
    public Optional<ShipmentRecord> getByShipmentCode(@PathVariable String code) {
        return shipmentRecordService.getShipmentByCode(code);
    }

    @GetMapping
    public List<ShipmentRecord> getAllShipments() {
        return shipmentRecordService.getAllShipments();
    }
}
