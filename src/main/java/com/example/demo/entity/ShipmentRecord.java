package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "shipments",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "shipment_code")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Shipment code is required")
    @Column(name = "shipment_code", nullable = false, unique = true)
    private String shipmentCode;

    private String origin;

    private String destination;

    @NotBlank(message = "Product type is required")
    private String productType;

    private String status;

    private LocalDateTime createdAt;

    /* ================= RELATIONSHIPS ================= */

    @OneToMany(
        mappedBy = "shipment",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<TemperatureLog> temperatureLogs;

    @OneToMany(
        mappedBy = "shipment",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<BreachRecord> breachRecords;

    /* ================= LIFECYCLE ================= */

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.status = "CREATED";
    }
}
