package com.example.weather_api.controller;

import com.example.weather_api.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private WeatherService service;
    @GetMapping("/{city}")
    public ResponseEntity<String> getWeather(@PathVariable String city) {
        return new ResponseEntity<>(service.getWeatherByCity(city) , HttpStatus.OK);
    }
}
