package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AlertRecord {

    @Id
    @GeneratedValue
    private Long id;

    private Long shipmentId;
    private Boolean acknowledged;
    private LocalDateTime sentAt;

    @PrePersist
    public void init() {
        acknowledged = false;
        sentAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getShipmentId() { return shipmentId; }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }

    public Boolean getAcknowledged() { return acknowledged; }
    public LocalDateTime getSentAt() { return sentAt; }
}
