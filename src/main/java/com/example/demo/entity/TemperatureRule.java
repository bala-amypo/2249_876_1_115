package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minTemp;
    private Double maxTemp;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    public TemperatureRule() {}

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Double getMinTemp() {
        return minTemp;
    }
 
    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }
 
    public Double getMaxTemp() {
        return maxTemp;
    }
 
    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }
 
    public LocalDate getEffectiveFrom() {
        return effectiveFrom;
    }
 
    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }
 
    public LocalDate getEffectiveTo() {
        return effectiveTo;
    }
 
    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
    }
}
