package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "temperature_sensor_logs")
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureSensorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shipmentId;

    private Double temperatureValue;

    private LocalDateTime recordedAt;

    private String location;

    public TemperatureSensorLog(Long shipmentId, Double temperatureValue, LocalDateTime recordedAt, String location) {
        this.shipmentId = shipmentId;
        this.temperatureValue = temperatureValue;
        this.recordedAt = recordedAt;
        this.location = location;
    }
}
