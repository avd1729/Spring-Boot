package com.example.weather_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Weather {
    @Id
    private String city;
    private Double latitude;
    private Double longitude;
    private Double temperature;
    private Double humidity;
    private Double pressure;
    private Double windSpeed;
}
