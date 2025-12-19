package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_record")
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;
    private Long breachId;
    private String alertType;
    private String message;
    private LocalDateTime sentAt;
    private Boolean acknowledged;

    public AlertRecord() {}

    public AlertRecord(Long shipmentId, Long breachId, String alertType, String message) {
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.alertType = alertType;
        this.message = message;
    }

    @PrePersist
    public void prePersist() {
        sentAt = LocalDateTime.now();
        acknowledged = false;
    }
    public Long getId() { 
    return id;
    }
    public Long getShipmentId() { 
    return shipmentId; 
    }
    public void setShipmentId(Long shipmentId) { this.shipmentId = shipmentId; }
    public Long getBreachId() { 
    return breachId; 
    }
    public void setBreachId(Long breachId) { this.breachId = breachId; }
    public String getAlertType() {
     return alertType;
      }
    public void setAlertType(String alertType) { this.alertType = alertType; }
    public String getMessage() { 
    return message;
     }
    public void setMessage(String message) { this.message = message; }
    public LocalDateTime getSentAt() {
     return sentAt; 
     }
    public Boolean getAcknowledged() {
     return acknowledged;
      }
    public void setAcknowledged(Boolean acknowledged) { this.acknowledged = acknowledged; }
}
