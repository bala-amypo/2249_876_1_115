package com.yourapp.project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "shipment_record",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "shipment_code")
    }
)
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_code", nullable = false, unique = true)
    private String shipmentCode;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "expected_delivery", nullable = false)
    private LocalDateTime expectedDelivery;

    @Column(nullable = false)
    private String status;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "IN_TRANSIT";
        }
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getShipmentCode() {
        return shipmentCode;
    }

    public void setShipmentCode(String shipmentCode) {
        this.shipmentCode = shipmentCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getExpectedDelivery() {
        return expectedDelivery;
    }

    public void setExpectedDelivery(LocalDateTime expectedDelivery) {
        this.expectedDelivery = expectedDelivery;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
