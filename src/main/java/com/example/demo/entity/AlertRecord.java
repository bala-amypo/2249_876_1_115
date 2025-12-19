package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alert_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;

    private Long breachId;

    private boolean acknowledged;

    private LocalDateTime sentAt;

    @PrePersist
    public void prePersist() {
        acknowledged = false;
        if (sentAt == null) {
            sentAt = LocalDateTime.now();
        }
    }

    public AlertRecord(Long shipmentId, Long breachId, boolean acknowledged, LocalDateTime sentAt) {
        this.shipmentId = shipmentId;
        this.breachId = breachId;
        this.acknowledged = acknowledged;
        this.sentAt = sentAt;
    }
}
