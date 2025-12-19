package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minTemp;
    private Double maxTemp;
    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
}
