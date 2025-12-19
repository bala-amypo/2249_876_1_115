package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ShipmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private String status;

    public ShipmentRecord() {}

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getProductName() {
        return productName;
    }
 
    public void setProductName(String productName) {
        this.productName = productName;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
}
