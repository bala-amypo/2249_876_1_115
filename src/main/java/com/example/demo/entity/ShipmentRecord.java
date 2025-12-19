package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shipment_records")
public class ShipmentRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shipmentCode;
    private String origin;
    private String destination;
    private String status;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "shipment")
    private List<TemperatureSensorLog> temperatureLogs;

    @OneToMany(mappedBy = "shipment")
    private List<BreachRecord> breachRecords;

    public ShipmentRecord() {}
    public ShipmentRecord(String shipmentCode, String origin, String destination, String status) {
        this.shipmentCode = shipmentCode;
        this.origin = origin;
        this.destination = destination;
        this.status = status;
    }

    @PrePersist
    public void prePersist() {
        if(this.status == null) this.status = "IN_TRANSIT";
        if(this.createdAt == null) this.createdAt = LocalDateTime.now();
    }
    // Getters and setters
}
